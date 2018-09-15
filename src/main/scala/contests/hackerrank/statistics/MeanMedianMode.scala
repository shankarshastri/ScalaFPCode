/**
  * @author ShankarShastri
  *         Algorithm: MeanMedianMode
  */

package contests.hackerrank.statistics

import scala.io.StdIn._
import scala.math.BigDecimal.RoundingMode

object MeanMedianMode {
  def readLineToList(str: String = readLine) = str.replaceAll("\\s+$", "").split(" ").map(e => BigDecimal(e.trim)).toList
  
  def mean(l: List[BigDecimal]): BigDecimal = {
    l.sum / l.length
  }
  
  def median(l: List[BigDecimal]): BigDecimal = {
    val len = l.length
    if(len % 2 == 0) {
        (l(len/2 - 1) + l(len/2))/2
      }
    else l(len/2)
  }
  
  def mode(l: List[BigDecimal]): BigDecimal = {
    l.maxBy(e => l.count(_ == e))
  }
  
  def printBigDecimal(s: BigDecimal): Unit = {
    if(s % 1 == 0) println(s.setScale(0, RoundingMode.HALF_EVEN))
    else println(s.setScale(1, RoundingMode.HALF_EVEN))
  }
  
  
  def main(args: Array[String]): Unit = {
    readLine
    val l = readLineToList().sorted
    println(mean(l).setScale(1,  RoundingMode.HALF_EVEN))
    println(median(l).setScale(1,  RoundingMode.HALF_EVEN))
    printBigDecimal(mode(l))
  }
}
