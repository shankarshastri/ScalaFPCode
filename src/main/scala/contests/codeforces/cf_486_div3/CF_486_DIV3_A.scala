/**
  * @author ShankarShastri
  *         Algorithm: CF_486_DIV3_A(http://codeforces.com/contest/988/problem/A)
  */

package contests.codeforces.cf_486_div3

import scala.io.StdIn._

object CF_486_DIV3_A {
  //    5 3
  //    15 13 15 15 12

  def main(args: Array[String]): Unit = {
    val Array(n, nq) = readLine.split(" ").map(_.toInt)
    val arr = readLine.split(" ").map(_.toInt)
    val arrDistinct = arr.distinct
    if (arrDistinct.length < nq) {
      println("NO")
    } else {
      var x = 0
      val l = for {
        i <- 0 until nq
      } yield {
        x = arr.indexOf(arrDistinct(i), x)
        x
      }
      println("YES")
      println(l.map(_ + 1).mkString(" "))
    }
  }
}
