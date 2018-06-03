package sysdesign

import akka.actor._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt

case class Request(ip: String)

case class ClearRateLimit(ip: String)

case class StopScheduledClearRateLimit(ip: String)

case class RateLimitProps(limitVal: Int, isScheduled: Option[Cancellable])

class RateLimiter(requestLimit: Int, throttleTimeLimit: Int, stopPoller: Int)
  extends Actor {
  val mapOfUnique = scala.collection.mutable
    .Map[String, RateLimitProps]()
    .withDefaultValue(RateLimitProps(0, None))
  val stopScheduledAfterClearing =
    scala.collection.mutable.Map[String, Int]().withDefaultValue(0)

  override def receive: Receive = {
    case msg: Request if mapOfUnique(msg.ip).limitVal < requestLimit => {
      println(
        s"Recieved Request ${msg.ip}, Current Limit: ${mapOfUnique(msg.ip).limitVal}")
      val currentReq = mapOfUnique(msg.ip)
      currentReq.isScheduled match {
        case Some(_) =>
          mapOfUnique.update(
            msg.ip,
            currentReq.copy(limitVal = currentReq.limitVal + 1))
        case None => {
          val cancellable = context.system.scheduler.schedule(
            0 second,
            throttleTimeLimit second,
            self,
            ClearRateLimit(msg.ip))
          mapOfUnique.update(
            msg.ip,
            RateLimitProps(currentReq.limitVal + 1, Some(cancellable)))
        }
      }
    }
    case msg: Request => {
      println(s"Rate Limiting for request: ${msg.ip}")
    }
    case msg: ClearRateLimit => {
      println(s"Clearing RateLimit For ${msg.ip}")
      val getPollerInfo = stopScheduledAfterClearing(msg.ip)
      if (getPollerInfo < stopPoller) {
        mapOfUnique.put(msg.ip, mapOfUnique(msg.ip).copy(limitVal = 0))
        stopScheduledAfterClearing.put(msg.ip, getPollerInfo + 1)
      } else {
        println(s"Stopping RateLimit Clearer for ${msg.ip}")
        val currentVal = mapOfUnique(msg.ip)
        mapOfUnique.put(msg.ip, currentVal.copy(limitVal = 0, None))
        currentVal.isScheduled.map(_.cancel() == true)
      }

    }
    case _ => {
      println("Rate Limiting")
    }
  }
}

object RateLimiterActor {
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem("actorSystem")
    val actor = actorSystem.actorOf(Props(classOf[RateLimiter], 10, 1, 10),
      "rateLimitActor")
    (1 to 15).foreach(_ => actor ! Request("1"))
    Thread.sleep(1000)
    (1 to 15).foreach(_ => actor ! Request("1"))
    Thread.sleep(1000)
    (1 to 15).foreach(_ => actor ! Request("1"))

  }
}
