package stackoverflow

import akka.actor._
import akka.util.Timeout
import scala.concurrent.duration.DurationInt

class Producer extends Actor {
  def receive = {
    case _ => println("Producer received a message")
  }
}

case object KillConsumer

class Consumer extends Actor {

  def receive = {
    case KillConsumer =>
      println("Stopping Consumer After All Producers")
      context.stop(self)
    case _ => println("Parent received a message")
  }

  override def postStop(): Unit = {
    println("Post Stop Consumer")
    super.postStop()
  }
}

class ProducerWatchers(producerListRef: List[ActorRef], consumerRef: ActorRef) extends Actor {
  producerListRef.foreach(x => context.watch(x))
  context.watch(consumerRef)
  var producerActorCount = producerListRef.length
  implicit val timeout: Timeout = Timeout(5 seconds)
  override def receive: Receive = {
    case Terminated(x) if producerActorCount == 1 && producerListRef.contains(x) =>
      consumerRef ! KillConsumer

    case Terminated(x) if producerListRef.contains(x) =>
      producerActorCount -= 1

    case Terminated(`consumerRef`) =>
      println("Killing ProducerWatchers On Consumer End")
      context.stop(self)

    case _ => println("Dropping Message")
  }

  override def postStop(): Unit = {
    println("Post Stop ProducerWatchers")
    super.postStop()
  }
}

object ProducerWatchers {
  def apply(producerListRef: List[ActorRef], consumerRef: ActorRef) : Props = Props(new ProducerWatchers(producerListRef, consumerRef))
}

object AkkaActorKill {
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem("AkkaActorKill")
    implicit val timeout: Timeout = Timeout(10 seconds)

    val consumerRef = actorSystem.actorOf(Props[Consumer], "Consumer")
    val producer1 = actorSystem.actorOf(Props[Producer], name = "Producer1")
    val producer2 = actorSystem.actorOf(Props[Producer], name = "Producer2")
    val producer3 = actorSystem.actorOf(Props[Producer], name = "Producer3")

    val producerWatchers = actorSystem.actorOf(ProducerWatchers(List[ActorRef](producer1, producer2, producer3), consumerRef),"ProducerWatchers")

    producer1 ! PoisonPill
    producer2 ! PoisonPill
    producer3 ! PoisonPill

    Thread.sleep(5000)
    actorSystem.terminate
  }
}