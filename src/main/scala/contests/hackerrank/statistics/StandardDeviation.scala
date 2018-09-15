/**
  * @author ShankarShastri
  *         Algorithm: StandardDeviation
  */

package contests.hackerrank.statistics

import scala.io.StdIn.readLine
import scala.annotation.tailrec
import scala.math.BigDecimal.RoundingMode

object StandardDeviation {
  
  def sqroot(n: BigDecimal, x0: BigDecimal=1): BigDecimal = {
    @tailrec
    def sqrootHelper(xn: BigDecimal): BigDecimal = {
      val cal = ((xn+n/xn)/2).setScale(1, BigDecimal.RoundingMode.HALF_EVEN)
      val roundedXn = xn.setScale(1, BigDecimal.RoundingMode.HALF_EVEN)
      roundedXn match {
        case x  if cal == x =>
          cal
        case _ => sqrootHelper(cal)
      }
    }
    sqrootHelper(x0)
  }
  
  def mean(l: List[BigDecimal]): BigDecimal = {
    l.sum / l.length
  }
  
  def stdDeviation(l: List[BigDecimal]): BigDecimal = {
    val meanL = mean(l)
    sqroot(((l.map(e => (meanL - e).pow(2)).sum)/l.length).setScale(1, RoundingMode.HALF_EVEN))
  }
  
  def readLineToList(str: String = readLine): List[BigDecimal] = str.replaceAll("\\s+$", "").split(" ").map(e => BigDecimal(e.trim)).toList
  
  def main(args: Array[String]): Unit = {
    readLine
    println(stdDeviation(readLineToList()))
  }
}