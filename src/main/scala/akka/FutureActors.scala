package akka

import akka.actor.{Actor, ActorSystem, Props}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global



case object ReturnFuture
class FutureActors extends  Actor {

  override def receive: Receive = {
    case ReturnFuture =>
      Future {

        println("Hello")
      }
  }

}

object main extends  App {
  val akkaActorSystem = ActorSystem("FutActorSystem")
  val x = akkaActorSystem.actorOf(Props[FutureActors], "FutureActor")
  x ! ReturnFuture
}