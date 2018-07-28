/**
  * @author ShankarShastri
  *         Algorithm: NewtonsSquareRoot
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec

object NewtonsSquareRoot {
  
  def sqroot(n: BigDecimal, x0: BigDecimal=1): BigInt = {
    @tailrec
    def sqrootHelper(xn: BigDecimal): BigDecimal = {
      val cal = ((xn+n/xn)/2).setScale(0, BigDecimal.RoundingMode.HALF_EVEN)
      val roundedXn = xn.setScale(0, BigDecimal.RoundingMode.HALF_EVEN)
      roundedXn match {
        case x  if cal == x =>
          cal
        case _ => sqrootHelper(cal)
      }
    }
    sqrootHelper(x0).toBigInt
  }
  
  def main(args: Array[String]): Unit = {
    sqroot(1000)
  }
}
