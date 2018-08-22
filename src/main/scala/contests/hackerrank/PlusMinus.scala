/**
  * @author ShankarShastri
  *         Algorithm: PlusMinus
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec
object PlusMinus {
  
  // Complete the plusMinus function below.
  def plusMinus(l: Array[Int]) {
    println((BigDecimal(l.filter(_ > 0).length) / BigDecimal(l.length)).setScale(6, BigDecimal.RoundingMode.HALF_UP))
    println((BigDecimal(l.filter(_ < 0).length)/ BigDecimal(l.length)).setScale(6, BigDecimal.RoundingMode.HALF_UP))
    println((BigDecimal(l.filter(_ == 0).length)/ BigDecimal(l.length)).setScale(6, BigDecimal.RoundingMode.HALF_UP))
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    
    val n = stdin.readLine.trim.toInt
    
    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    plusMinus(arr)
  }
}
