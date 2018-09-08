/**
  * @author ShankarShastri
  *         Algorithm: PE14
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object CollatzSeq {
  
  // Using Array As Performance Is Better Than Map
  private final val collatzSeq = Array.fill[BigInt](5* 1000 * 1000)(0)
  def longestCollatzSeq(n: BigInt): BigInt = {
    def longestCollatzSeqHelper(n: BigInt, count: BigInt = 0): BigInt = {
      val countOfN = collatzSeq((n - 1).toInt)
      n match {
        case n if n == 1 => count
        case _ if countOfN != 0 =>
          count + countOfN
        case n if n % 2 == 0 =>
          val updateForEven = longestCollatzSeqHelper(n/2, count + 1)
          collatzSeq.update((n-1).toInt, updateForEven - count)
          updateForEven
        case n if n % 2 != 0 =>
          val updateForOdd = longestCollatzSeqHelper(3 * n + 1 , count + 1)
          collatzSeq.update((n-1).toInt, updateForOdd - count)
          updateForOdd
      }
    }
    longestCollatzSeqHelper(n)
  }
}

object PE14 {
  def loopWithRes[T](n: BigInt)(block: => T): List[T] = (BigInt(1) to n).map(_ => block).toList
  
  // Direct Implementation Without Cache Support
  @tailrec
  def collatzSequence(s:BigInt, count: BigInt = 0): BigInt = {
    s match {
      case s if s == 1 => count
      case s if s % 2 == 0 => collatzSequence(s/2, count+1)
      case s => collatzSequence(3*s + 1, count+1)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val t = BigInt(readLine)
    loopWithRes[Unit](t) {
      val n = BigInt(readLine)
      val res = (BigInt(1) to (n)).foldLeft((BigInt(0),BigInt(0)))((a,b) => {
        val res = (b, CollatzSeq.longestCollatzSeq(b))
        if(a._2 <= res._2) res
        else a
      })
      println(res._1)
    }
  }
}


