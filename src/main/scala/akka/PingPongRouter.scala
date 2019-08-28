package akka

import akka.actor._
import akka.routing.{Broadcast, DefaultResizer, RoundRobinPool}


case object Init
case object Pong
case object Ping

class PingActor(pongActorRef: ActorRef) extends Actor {
  def receive: Receive = {
    case Init =>
      println("Init")
      pongActorRef.tell(Ping, context.parent)

    case Pong =>
      println("pong")
      println(self)
      Thread.sleep(1000)
      pongActorRef.tell(Ping, context.parent)

    case _ => println("I don't get it ping")
  }
}

class PongActor() extends Actor {
  def receive: Receive = {

    case Ping =>
      println("ping")
      println(self)
      Thread.sleep(1000)
      sender.tell(Pong, context.parent)

    case _ => println("I don't get it pong")
  }
}

object PingPongRouter extends App {

  val actorSystem = ActorSystem("PingPongActor")

  val resizer =
    DefaultResizer(lowerBound = 1, upperBound = 15, messagesPerResize = 1)

  val pongRouter: ActorRef =
    actorSystem.actorOf(
      RoundRobinPool(2, Some(resizer)).props(Props(classOf[PongActor])),
      "pongRouter")

  val pingRouter: ActorRef =
    actorSystem.actorOf(RoundRobinPool(2, Some(resizer))
      .props(Props(new PingActor(pongRouter))),
      "pingRouter")

  pingRouter ! Broadcast(Init)
}


