/**
  * @author ShankarShastri
  *         Algorithm: Quartile
  */

package contests.hackerrank.statistics

import scala.io.StdIn._
import scala.annotation.tailrec

object Quartile {
  import scala.io.StdIn._
  import scala.math.BigDecimal.RoundingMode
  
  def median(l: List[BigDecimal]): BigDecimal = {
    val len = l.length
    if(len % 2 == 0) {
      ((l(len/2 - 1) + l(len/2))/2).setScale(1, RoundingMode.HALF_EVEN)
    }
    else (l(len/2)).setScale(1, RoundingMode.HALF_EVEN)
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
  
  def main(args: Array[String]) {
    readLine
    val res = quartile(readLine.split(" ").map(BigDecimal(_)).toList)
    println(res._1.toInt)
    println(res._2.toInt)
    println(res._3.toInt)
  }
}