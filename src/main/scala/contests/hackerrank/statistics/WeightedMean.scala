/**
  * @author ShankarShastri
  *         Algorithm: WeightedMean
  */

package contests.hackerrank.statistics

import scala.io.StdIn._
import scala.math.BigDecimal.RoundingMode

object WeightedMean {
  def readLineToList(str: String = readLine) = str.replaceAll("\\s+$", "").split(" ").map(e => BigDecimal(e.trim)).toList
  def main(args: Array[String]): Unit = {
    readLine
    val x = readLineToList()
    val w = readLineToList()
    println((((x zip w).map(e => e._1 * e._2).sum)/w.sum).setScale(1, RoundingMode.HALF_EVEN))
  }
}
