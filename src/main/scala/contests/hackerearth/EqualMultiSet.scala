/**
  * @author ShankarShastri
  *         Algorithm: EqualMultiSet
  */

package contests.hackerearth

import scala.io.StdIn._
import scala.annotation.tailrec

object EqualMultiSet {
  def readLineToList = readLine.replaceAll("\\s+$", "").split(" ")
    .map(e => BigInt(e.trim)).toList
  
  def main(args: Array[String]): Unit = {
    readLine
    val a = readLineToList.sorted
    val b = readLineToList.sorted
    println(((a zip b).map(e => (e._1 - e._2).abs).sum).mod(BigInt(10).pow(9) + 7))
  }
}
