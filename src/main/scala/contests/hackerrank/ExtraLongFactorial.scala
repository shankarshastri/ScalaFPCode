/**
  * @author ShankarShastri
  *         Algorithm: ExtraLongFactorial
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object ExtraLongFactorial {
  
  def extraLongFactorials(n: Int) {
    println((BigInt(1) to BigInt(n)).reduce(_ * _))
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    extraLongFactorials(n)
  }
}
