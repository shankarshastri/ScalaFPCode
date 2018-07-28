/**
  * @author ShankarShastri
  *         Algorithm: PE3
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec


object PE3 {
  
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
  
  def checkEvenAndDivide(n: BigInt): BigInt = {
    n match {
      case x if x % 2 == 0 => checkEvenAndDivide(n/2)
      case _ => n
    }
  }
  
  def factors(n: BigInt): List[BigInt] =
    {
      (BigInt(2) to sqroot(BigDecimal((n)))).par.seq.view.find(n % _ == 0).fold(List(n))(i => i :: factors(n / i))
    }
  
  def loopWithResForBigInt[T](n: BigInt)(block: => T)(res: List[T] = List[T]()): List[T] = {
    n match {
      case x: BigInt if x == BigInt(0) => res
      case _ => loopWithResForBigInt(n-1)(block)(block :: res)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val t = readInt
    loopWithResForBigInt(t) {
        val n = BigInt(readLine)
        println(factors(checkEvenAndDivide(n)).last)
    }()
  }
}
