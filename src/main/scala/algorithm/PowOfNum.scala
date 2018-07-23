/**
  * @author ShankarShastri
  *         Algorithm: PowOfNum
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec

object PowOfNum {
  import scala.annotation.tailrec

  def powNum(x: Double, n: Int): Double = Math.exp(n * Math.log(x)).round
  
  def powCalc(x: Double, n: Double): Double = {
    n match {
      case x if x <= 0 => 1
      case _ => x * powCalc(x, n-1)
    }
  }


  def powCalcTail(x: Double, n: Double): Double = {
    @tailrec
    def powCalcTailHelper(n: Double, accumRes: Double = 1): Double = {
      n match {
        case x if x <= 0 => accumRes
        case _ => powCalcTailHelper(n - 1, accumRes * x)
      }
    }
    powCalcTailHelper(n)
  }

  def powWithoutLib(x: Double, n: Double) = {
    if (n < 0)
      1 / powCalcTail(x, n * -1)
    else
      powCalcTail(x, n)
  }

  def main(args: Array[String]): Unit = {
    powWithoutLib(2, -2)
  }
}
