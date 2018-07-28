/**
  * @author ShankarShastri
  *         Algorithm: PE4
  */

package contests.project_euler

import scala.io.StdIn._

object PE4 {
  
  
  def isPalindrome(x: Int) = {
    x.toString == x.toString.reverse
  }
  
  val res =
    for {
      i <- 100 to 999
      j <- i to 999
      if isPalindrome(i * j)
    } yield i * j
  
  def loopWithResForBigInt[T](n: BigInt)(block: => T)(res: List[T] = List[T]()): List[T] = {
    n match {
      case x: BigInt if x == BigInt(0) => res
      case _ => loopWithResForBigInt(n-1)(block)(block :: res)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val t = readInt
      loopWithResForBigInt(t) {
        val n = readInt
        println(res.filter(_ < n).sorted.last)
      }()
  }
}
