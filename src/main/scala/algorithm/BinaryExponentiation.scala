/**
  * @author ShankarShastri
  *         Algorithm: BinaryExponentiation (https://cp-algorithms.com/algebra/binary-exp.html)
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec


object BinaryExponentiation {
  import cats.Eval
  
  def binExponentiation(a: BigInt, n: BigInt): Eval[BigInt] = {
    def binExponentiationHelper(a: BigInt, n: BigInt): Eval[BigInt] = {
      if(n == 0) Eval.now(BigInt(1))
      else {
        val res = Eval.defer(binExponentiationHelper(a, n/2))
        if(n % 2 == 1) res.flatMap(e => res.map(e1 => e * e1 * a))
        else res.flatMap(e => res.map(_ * e))
      }
    }
    binExponentiationHelper(a, n)
  }
  
  def calcPerformance[T](mT: => T) = {
    val a = System.nanoTime()
    mT
    System.nanoTime() - a
  }
  
  
  def main(args: Array[String]): Unit = {
    println(calcPerformance(binExponentiation(100, 200).value))
    println(calcPerformance(BigInt(100).pow(200)))
  }
}
