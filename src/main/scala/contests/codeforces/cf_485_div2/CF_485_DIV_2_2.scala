package contests.codeforces.cf_485_div2

/**
  * @author ShankarShastri
  *         Algorithm: CF_485_DIV_2_2(http://codeforces.com/contest/987/problem/B)
  */
//package programming

import scala.io.StdIn._

object CF_485_DIV_2_2 {
  //https://en.wikipedia.org/wiki/Exponentiation_by_squaring

  def main(args: Array[String]): Unit = {
    val Array(x, y) = readLine.split(" ").map(_.toDouble)

    val xy = Math.log(x) / y
    val yx = Math.log(y) / x
    if (xy > yx) println(">")
    else if (xy < yx) println("<")
    else println("=")
  }
}
