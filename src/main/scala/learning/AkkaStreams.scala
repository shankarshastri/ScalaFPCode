/**
  * @author ShankarShastri
  *         Algorithm: AkkaStreams
  */

package learning

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
object AkkaStreams {
  def main(args: Array[String]): Unit = {
    
    implicit val system = ActorSystem()
    implicit val actorMaterializer = ActorMaterializer()
    val source = Source(List(1,2,3,4))
    val sink = Sink.reduce[Int](_ + _)
    val sum: Future[Int] = source.runWith(sink)
    sum.onComplete{
      case Success(value) =>
        println(value)
        system.terminate
      case _ => system.terminate
    }
  }
}
