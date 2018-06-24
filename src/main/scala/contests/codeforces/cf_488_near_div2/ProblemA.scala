/**
  * @author ShankarShastri
  *         Algorithm: ProblemA (http://codeforces.com/contest/994/problem/A)
  */

package contests.codeforces.cf_488_near_div2

import scala.io.StdIn._
import scala.annotation.tailrec

object ProblemA {
  def main(args: Array[String]): Unit = {
    readLine
    val list = readLine.split(" ").map(_.toInt).toList
    val keys = readLine.split(" ").map(_.toInt).toList
    val res = keys.map(x => (x, list.indexOf(x))).filter(_._2 != -1).sortBy(_._2).map(_._1)
    println(res.mkString(" "))
  }
}
