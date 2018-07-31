/**
  * @author ShankarShastri
  *         Algorithm: PE8
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object PE8 {
  
  def consecProductOfNumbers(n: BigInt): BigInt = {
      if (n == 0) 1
      else n % 10 * consecProductOfNumbers(n / 10)
  }
  
  @tailrec
  def loopWithResForBigInt[T](n: BigInt)(block: => T)(
    res: List[T] = List[T]()): List[T] = {
    n match {
      case x: BigInt if x == BigInt(0) => res
      case _                           => loopWithResForBigInt(n - 1)(block)(block :: res)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val t = readInt
  
    loopWithResForBigInt(t) {
      val Array(_, k) = readLine.split(" ").map(_.toInt)
      val n = readLine
      val res = for {
        i <- 0 to n.length - k
      } yield {
        val productList = for {
          j <- i until k+i
        } yield {
          n(j).toString.toInt
        }
        productList.foldLeft(1)(_ * _)
      }
      println(res.max)
    }()
  }
}
