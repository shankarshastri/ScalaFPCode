/**
  * @author ShankarShastri
  *         Algorithm: InterQuartileRange
  */

package contests.hackerrank.statistics

import scala.io.StdIn._
import scala.math.BigDecimal.RoundingMode

object InterQuartileRange {
  
  def median(l: List[BigDecimal]): BigDecimal = {
    val len = l.length
    if(len % 2 == 0) {
      ((l(len/2 - 1) + l(len/2))/2).setScale(1, RoundingMode.HALF_EVEN)
    }
    else l(len/2).setScale(1, RoundingMode.HALF_EVEN)
  }
  
  def quartile(l: List[BigDecimal]): (BigDecimal, BigDecimal, BigDecimal) = {
    val sortedL = l.sorted
    if(sortedL.length % 2 == 0)
    {
      val (l1,l2) = sortedL.splitAt(sortedL.length/2)
      (median(l1), median(sortedL), median(l2))
    } else {
      val (l1,l2) = sortedL.splitAt(sortedL.length/2)
      (median(l1), sortedL(sortedL.length/2), median(l2.tail))
    }
  }
  
  def interQuartileRange(l: List[BigDecimal], c : List[BigDecimal]): BigDecimal = {
    val actualList = (l zip c).flatMap(e => List.fill(e._2.toInt)(e._1))
    val (q1, _, q3) = quartile(actualList)
    q3 - q1
  }
  
  def main(args: Array[String]): Unit =  {
    readLine
    val l = readLine.split(" ").map(BigDecimal(_)).toList
    val c = readLine.split(" ").map(BigDecimal(_)).toList
    println(interQuartileRange(l,c))
  }
}