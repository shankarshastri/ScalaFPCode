package akka

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt
import scala.concurrent.ExecutionContext.Implicits.global



case object ReturnFuture
class FutureActors extends  Actor {

  override def receive: Receive = {
    case ReturnFuture =>
        context.setReceiveTimeout(1 second)
        sender() ! akka.actor.Status.Failure(new Exception("Hello"))
  }
}

object main extends  App {
  val akkaActorSystem = ActorSystem("FutActorSystem")
  val x = akkaActorSystem.actorOf(Props[FutureActors], "FutureActor")
  implicit val timeOut = Timeout(5 second)
  val l = x ? ReturnFuture
  println(Await.result(l, 5 second))
}