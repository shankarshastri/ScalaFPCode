/**
  * @author ShankarShastri
  *         Algorithm: GapUpAndGapDown(https://www.hackerrank.com/contests/moodys-analytics-2018-university-codesprint/challenges/gap-up-down)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object GapUpAndGapDown {
  def readLineToList: List[Int] =
    readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
  
  def main(args: Array[String]): Unit = {
    val low = readLineToList.tail
    val high = readLineToList.tail
    val close = readLineToList.init
    println((low zip close).map(e => e._1 > e._2).count(e => e))
    println((high zip close).map(e => e._1 < e._2).count(e => e))
  }
}
