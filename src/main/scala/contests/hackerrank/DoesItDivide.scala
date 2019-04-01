/**
  * @author ShankarShastri
  *         Algorithm: DoesItDivide
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object DoesItDivide {
  
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
  
  def factors(n: BigInt): List[BigInt] =
    (BigInt(2) to sqroot(BigDecimal((n)))).par.seq.view.find(n % _ == 0).fold(List(n))(i => i :: factors(n / i))
  
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    loop(t) {
      val n = readLine.toInt
      val f  = factors(n+1).distinct
      if(f.count(_ <= n-1) == f.length) {
        println("YES")
      } else println("NO")
    }
  }
}
