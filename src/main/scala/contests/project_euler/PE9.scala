/**
  * @author ShankarShastri
  *         Algorithm: PE9
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object PE9 {
  
  import scala.io.StdIn._
  
  // Generating Triple Using Euclid Method
  def a(m: BigInt, n: BigInt): BigInt = m.pow(2) - n.pow(2)
  
  def b(m: BigInt, n: BigInt): BigInt = 2 * m * n
  
  def c(m: BigInt, n: BigInt): BigInt = m.pow(2) + n.pow(2)
  
  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (a == BigInt(0)) b
    else gcd(b % a, a)
  }
  
  def calcPythagorean(m: BigInt, n: BigInt): BigInt = {
    if (gcd(m, n) == 1)
      c(m, n).pow(2)
    else
      0
  }
  
  def calcPythagoreanForSum(m: BigInt, n: BigInt,
                            sum: BigInt): BigInt = {
    val a1 = a(m, n).abs
    val b1 = b(m, n)
    val c1 = c(m, n)
//    println(a1,b1,c1)
    if (gcd(m, n) == 1 && sum == a1 + b1 + c1)
      a1 * b1 * c1
    else
      0
  }
  
  def loopWithReadLine[T](n: BigInt)(block: String => T): Unit =
    (BigInt(1) to n).map(_ => {
      println(block(readLine))
    })
  
  def main(args: Array[String]) {
    val t = readLine
    loopWithReadLine(BigInt(t)) {
      e => {
        val res = (for {
          i <- (BigInt(1) until BigInt(e))
          j <- (i+1) until BigInt(e)
        } yield {
          calcPythagoreanForSum(i, j, BigInt(e))
        }).max
        
        if(res == 0) -1
        else res
      }
    }
  }
}