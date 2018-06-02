package akka

import akka.actor._

object PingPongActor extends App {

  val actorSystem = ActorSystem("PingPongActor")
  val pongActorRef = actorSystem.actorOf(Props[PongActor])
  val pingActorRef =
    actorSystem.actorOf(Props(classOf[PingActor], pongActorRef))

  //  val pingPongInitiatorActorRef = actorSystem.actorOf(Props(classOf[PingPongInitiatorActor], pingActorRef))

  println(pongActorRef)
  println(pingActorRef)
  //  println(pingPongInitiatorActorRef)

  pingActorRef ! Init
}

case object Init

case object Pong

case object Ping

//class PingPongInitiatorActor(pingActorRef: ActorRef) extends Actor {
//  override def receive: Receive = {
//    case init => {
//      println("init begins PingPongInitiator")
//      pingActorRef ! init
//    }
//  }
//}

class PingActor(pongActorRef: ActorRef) extends Actor {
  def receive: Receive = {
    case Init => {
      println("init begins ping actor")
      println(pongActorRef)
      pongActorRef ! Ping
    }
    case Pong => {
      println("pong")
      sender ! Ping
    }
    case _ => println("I don't get it ping")
  }
}

class PongActor() extends Actor {
  def receive: Receive = {
    case Ping => {
      println("ping")
      println(sender)
      sender ! Pong
    }
    case _ => println("I don't get it pong")
  }
}
