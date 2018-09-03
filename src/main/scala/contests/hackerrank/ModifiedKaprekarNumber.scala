/**
  * @author ShankarShastri
  *         Algorithm: ModifiedKaprekarNumber
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec



object ModifiedKaprekarNumber {
  
  def filterTrailingZeroes(s: BigInt): BigInt = {
    (s % 10 == 0) match {
      case true => filterTrailingZeroes(s/10)
      case _ => s
    }
  }
  
  def kaprekarNumber(s: Int): Boolean = {
    val sPow = BigDecimal(Math.pow(s, 2)).toBigInt.toString
    if(sPow.length > 1)
    {
      val l = sPow.splitAt(sPow.length/2)
      (s == BigInt(l._1) + BigInt(l._2))
    } else
      s == BigInt(sPow)
  }
  
  def kaprekarNumbers(p: Int, q: Int): Unit = {
    val l = for {
      i <- p to q
      if kaprekarNumber(i)
    } yield i
    l.toList match {
      case Nil => println("INVALID RANGE")
      case _ => println(l.mkString(" "))
    }
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val p = stdin.readLine.trim.toInt
    val q = stdin.readLine.trim.toInt
    kaprekarNumbers(p, q)
  }
}