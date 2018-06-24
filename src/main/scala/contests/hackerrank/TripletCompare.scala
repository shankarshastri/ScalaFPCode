/**
  * @author ShankarShastri
  *         Algorithm: TripletCompare(https://www.hackerrank.com/challenges/compare-the-triplets/problem)
  */
package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object TripletCompare {
  def readLineToList = readLine.split(" ").map(_.toInt).toList

  def main(args: Array[String]): Unit = {
    val a = readLineToList
    val b = readLineToList
    val zippedList = (a zip b)
    val resA = zippedList.filter(x => x._1 > x._2).length
    val resB = zippedList.filter(x => x._2 > x._1).length
    println(s"$resA $resB")
  }
}
