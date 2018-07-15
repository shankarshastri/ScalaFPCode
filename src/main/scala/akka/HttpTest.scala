/**
  * @author ShankarShastri
  *         Algorithm: HttpTest
  */

package akka
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http._
import scala.concurrent.ExecutionContext.Implicits.global
import akka.http.scaladsl.model.HttpRequest

import scala.util.Success



object HttpTest {
  def main(args: Array[String]): Unit = {
    implicit val actorSystem = ActorSystem("Dummy")
    val request = HttpRequest(uri = "http://localhost:8080/hello")
      val res = Http().singleRequest(request)
    res.onComplete {
      case Success(res) => println(res)
      case x => println(x)
    }
  }
}
