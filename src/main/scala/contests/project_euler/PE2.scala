/**
  * @author ShankarShastri
  *         Algorithm: PE2
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt


object PE2 {
  
  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
  
  def customFib(n:BigInt) = {
    @tailrec
    def fibHelper(n: BigInt, value: BigInt, accumList: List[BigInt]=List[BigInt](),
                  accum: BigInt=0):List[BigInt] = {
      n match {
        case x if x <=0 => (accumList)
        case x if (accum + value) % 2 == 0 =>
          fibHelper(n-1, accum, (accum + value) :: accumList , accum + value)
        case _ => fibHelper(n-1, accum, accumList ,accum + value)
      }
    }
    fibHelper(n, 1)
  }
  
  def sum(l: List[BigInt]): BigInt = {
    l match {
      case Nil => BigInt(0)
      case h :: t => h + sum(t)
    }
  }
  
  val res = Future {
      customFib(85)
  }
  
  def main(args: Array[String]): Unit = {
    val r = Await.result(res, 10 seconds)
    r match {
      case l: List[BigInt] => {
        val t = readInt
        loopWithRes(t){
          val q = BigInt(readLine)
          println(sum(l.filter(_ < q)))
        }
      }
      case _ =>
    }
  }
}
