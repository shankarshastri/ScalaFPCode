/**
  * @author ShankarShastri
  *         Algorithm: GeneratingPythagoreanTriplets
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec

object GeneratingPythagoreanTriplets {
  // Generating Triple Using Euclid Method
  def a(m: BigInt, n: BigInt): BigInt = m.pow(2) - n.pow(2)
  def b(m: BigInt, n: BigInt): BigInt = 2*m*n
  def c(m: BigInt, n: BigInt): BigInt = m.pow(2) + n.pow(2)
  
  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (a == BigInt(0))  b
    else gcd(b % a, a)
  }
  
  def calcPythagorean(m: BigInt, n: BigInt): BigInt  = {
    if(gcd(m,n) == 1)
      c(m,n).pow(2)
    else
      0
  }
  
  def main(args: Array[String]): Unit = {
    val m = 2
    val n = 3
    
    println(calcPythagorean(m,n))
  }
}
