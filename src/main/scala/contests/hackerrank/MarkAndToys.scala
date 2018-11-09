/**
  * @author ShankarShastri
  *         Algorithm: MarkAndToys (
  *         https://www.hackerrank.com/challenges/mark-and-toys/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec
object MarkAndToys {
  
  @tailrec
  def maxToys(l: List[Int], k:Int, count: Int = 0): Int = {
    l match {
      case Nil => count
      case head :: tail if k - head > 0 => maxToys(tail, k-head, count+1)
      case _ => count
    }
  }
  
  def main(args: Array[String]): Unit = {
    val Array(_, k) = readLine.split(" ").map(_.toInt)
    val l = readLine.split(" ").map(_.toInt).sorted.toList
    println(maxToys(l, k))
  }
}
