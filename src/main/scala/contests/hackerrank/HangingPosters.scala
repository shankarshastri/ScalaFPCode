/**
  * @author ShankarShastri
  *         Algorithm: HangingPosters (https://www.hackerrank.com/contests/hourrank-31/challenges/hanging-posters)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec
//
//3 5
//15 11 17
//5 1 2
object HangingPosters {
  def main(args: Array[String]): Unit = {
    val Array(_, h) = readLine.split(" ").map(_.toDouble)
    val boltPoints = readLine().split(" ").map(_.toDouble).toList
    val heights = readLine.split(" ").map(_.toDouble).toList
    val hangingHeights = (boltPoints zip heights).map(e => Math.ceil(e._1 - (0.25 * e._2)))
    println(Math.max(hangingHeights.max - h, 0).toInt)
  }
}
