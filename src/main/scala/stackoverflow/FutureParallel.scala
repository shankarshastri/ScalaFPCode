/**
  * @author ShankarShastri
  *         Algorithm: FutureParallel
  */

package stackoverflow

import scala.io.StdIn._
import scala.annotation.tailrec
import scala.concurrent.Future
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}



object FutureParallel {


  def main(args: Array[String]): Unit = {
    val l = List(Future(1), Future(3), Future(throw new Exception("Hello")))
    val listRes = l.map(x => x.transformWith(Future.successful))
    val finRes = for {
      res <- listRes
    } yield {
      for {
        result <- res
      } yield result
    }
    println(finRes)
    Thread.sleep(1000)
    println(finRes)
  }
}
