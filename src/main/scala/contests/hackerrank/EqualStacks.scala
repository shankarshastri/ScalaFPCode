/**
  * @author ShankarShastri
  *         Algorithm: EqualStacks (https://www.hackerrank.com/challenges/equal-stacks/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object EqualStacks {
  def readLineToList: List[Int] = readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
  def scanReverseCumulSum(l: List[Int]): List[Int] = l.reverse.scanLeft(0)(_ + _)
  
  def main(args: Array[String]): Unit = {
    readLine
    val a = scanReverseCumulSum(readLineToList)
    val b = scanReverseCumulSum(readLineToList)
    val c = scanReverseCumulSum(readLineToList)
    println(a.intersect(b).intersect(c).max)
  }
}
