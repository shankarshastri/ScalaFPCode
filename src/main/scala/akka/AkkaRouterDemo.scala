package akka

import java.util.UUID

import akka.actor.{Actor, ActorRef, ActorSystem, Props, Terminated}
import akka.dispatch.BalancingDispatcherConfigurator
import akka.routing.{Broadcast, DefaultOptimalSizeExploringResizer, DefaultResizer, OptimalSizeExploringResizer, RoundRobinPool}
import akka.util.Timeout

import scala.concurrent.Future

object AkkaRouterDemo {
  import akka.routing.{ ActorRefRoutee, RoundRobinRoutingLogic, Router }

  case class Name(s: String)
  case object Done


  class Worker extends Actor {
    override def receive: Receive =  {
      case _: Name =>
        context.parent ! Done
      case x: String =>
        x match {
          case _ => Thread.sleep(30000)
          case "Hello" => println("Hello")
        }
    }
  }


  class WorkerParam extends Actor {
    val mWorkerName = UUID.randomUUID()
    override def receive: Receive =  {
      case n: Name =>
        println(n.s)
        println(mWorkerName)

      case x: String =>
        x match {
          case _ =>
//            println(mWorkerName)
            sender() ! mWorkerName
          case "Hello" => println("Hello")
        }
    }
  }

  class Master extends Actor {
    var router = {
      val routees = Vector.fill(5) {
        val r = context.actorOf(Props[Worker], s"Worker-${UUID.randomUUID}")
        context.watch(r)
        ActorRefRoutee(r)
      }
      Router(RoundRobinRoutingLogic(), routees)
    }

    def receive = {
      case w: Name =>
        println(s"Recieved from ${sender()} ${w}")
        println(context.children.toList.length)
        router.route(w, self)

      case Done =>
        println("Done Recieved")

      case Terminated(a) =>
        println(s"Actor ${a} terminated")
        router = router.removeRoutee(a)
        val r = context.actorOf(Props[Worker])
        context.watch(r)
        router = router.addRoutee(r)

      case x =>
        println(x)
        router.route(x, self)
    }
  }


  def main(args: Array[String]): Unit = {
    import akka.pattern._
    import scala.concurrent.duration._
    import scala.concurrent.ExecutionContext.Implicits.global

    val actorSystem = ActorSystem("main")
    val actorDispatcher = actorSystem.dispatcher

    val resizer = DefaultResizer(lowerBound = 2, upperBound = 15, messagesPerResize = 1)

    val router30: ActorRef =
      actorSystem.actorOf(RoundRobinPool(1, Some(DefaultOptimalSizeExploringResizer())).props(Props(classOf[WorkerParam])),
        "router30")

    /**
      *
      * Akka Router => DefaultOptimalSizeExploringResizer + Balanced Dispatcher
      */
    //    val router = actorSystem.actorOf(Props[Master], "master")

    implicit val timeOut = Timeout(5 second)
    (1 to 50000).foldLeft(Future.successful(List.empty[UUID]))((a,_) => {
      val r = (router30 ? ("Hello1")).mapTo[UUID].flatMap(e => a.map(e :: _))
      r.map(e => println(e.distinct.length))
      r
    }).map(e => {
      println("#####")
      println(e.distinct.length)
      println("#####")
      actorSystem.terminate()
    })
  }
}
