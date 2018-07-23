/**
  * @author ShankarShastri
  *         Algorithm: WaitFuture
  */

package stackoverflow

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object WaitFuture {
  @tailrec
  def checkFutureComplete[T](f: => Future[T]): Unit = {
    if(f.isCompleted) ()
    else checkFutureComplete(f)
  }

  def main(args: Array[String]): Unit = {
  val k = Future {
    Thread.sleep(12000)
    println("Coming")
    10
  }
    checkFutureComplete(k)
    println(k)
    val k2 = k
    println(k2)
  }
}
//
//Coming
//Future(Success(10))
//Future(Success(10))