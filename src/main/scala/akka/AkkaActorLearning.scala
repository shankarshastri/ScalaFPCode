package akka

import akka.actor._
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import scala.concurrent.ExecutionContext.Implicits.global

class AkkaActorLearning {}

object HelloAkkaActorSystem extends App {
  val actorSystem = ActorSystem("Akka_Actor_System")
  println(actorSystem)
  //  val actorList: Seq[ActorRef] =
  //    (1 to 10).map(_ => actorSystem.actorOf(Props[SummingActor]))
  //   val actorWithConstructorList = (1 to 10).map(_ => actorSystem.actorOf(Props(classOf[SummingActorWithConstructor], 10)))
  //  // print actor path
  //  actorList.foreach(actor => println(actor.path))
  //  actorWithConstructorList.foreach(actor => print(actor.path))
  //  actorSystem.terminate
  //  implicit val timeout: Timeout = Timeout (1 second)
  //  val actorRef = actorSystem.actorOf(Props[SummingActor], "SummingActor")
  //  actorRef ! 10
  //  actorRef ! 10
  //  actorRef ! 10
  //  actorRef ! 10
  //  val x = actorRef.ask(10)(timeout, actorRef)
  //  x.onComplete{
  //    case Success(x) => println(x)
  //    case Failure(xFail) => println(xFail)
  //  }
  //  x.onComplete{
  //    _ => actorSystem.terminate
  //  }

  implicit val timeout: Timeout = Timeout(1 second)
  val actorRef = actorSystem.actorOf(Props[FibonacciSeries], "FibonacciSeries")
  actorRef ! 10
}

class SummingActor extends Actor {
  // state inside the actor
  var sum = 0

  // behaviour which is applied on the state
  override def receive: Receive = {
    // receives message an integer
    case x: Int =>
      sum = sum + x
      if (sum == 50) Thread.sleep(10000)
      println(s"my state as sum is $sum")
      Future{
        println("Hello")
      }
    // receives default message
    case _ => println("I don't know what are you talking about")
  }
}

class SummingActorWithConstructor(initialSum: Int = 0) extends Actor {
  // state inside the actor
  var sum = initialSum

  // behaviour which is applied on the state
  override def receive: Receive = {
    // receives message an integer
    case x: Int =>
      sum = sum + x
      println(s"my state as sum is $sum")
    // receives default message
    case _ => println("I don't know what are you talking about")
  }
}

class FibonacciSeries extends Actor {

  def fibonacci(x: Int): Int = {
    if (x == 1) 0
    else if (x == 2) 1
    else fibonacci(x - 1) + fibonacci(x - 2)
  }

  override def receive: Receive = {
    case x: Int => println(fibonacci(x))
    case _ =>
  }
}
