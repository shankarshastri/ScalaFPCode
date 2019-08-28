/**
  * @author ShankarShastri
  *         Algorithm: RecursiveDigitSum
  *         (https://www.hackerrank.com/challenges/recursive-digit-sum/)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec



object RecursiveDigitSum {
  import scala.annotation.tailrec
  
  @tailrec
  def supNum(num: String): String = {
    num match {
      case n if n.length == 1 => n
      case n => supNum(n.map(_.toString.toInt).sum.toString)
    }
  }
  
  def superDigit(n: String, k: Int): Int = {
    if(k%10 == 0)
      supNum(n).toInt
    else supNum(n*(k%10)).toInt
  }
  
  def main(args: Array[String]): Unit = {
    val n = "861568688536788"
    println(superDigit(n, 10000))
  }
}
