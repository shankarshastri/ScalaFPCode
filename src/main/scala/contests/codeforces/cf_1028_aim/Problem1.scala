/**
  * @author ShankarShastri
  *         Algorithm: Problem1 (http://codeforces.com/contest/1028/problem/A)
  */

package contests.codeforces.cf_1028_aim

import scala.io.StdIn._
import scala.annotation.tailrec

object FindSquares {
  
  def findSquare(ls: List[String]): (Int, Int) = {
    val l = ls.zipWithIndex.map(l => (l._2, l._1.indexOf('B'),
      l._1.lastIndexOf('B')))
      .filter(t => t._2 != -1 && t._3 != -1).map(e => (e._1 + 1, e._2 + 1, e._3 + 1))
    val le = l(l.length / 2)
    (le._1, (le._2 + le._3) / 2)
  }
  
  def main(args: Array[String]): Unit = {
    val List(r,_) = readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
    val strList = (1 to r).map(_ => readLine).toList
    val res = findSquare(strList.map(_.trim))
    println(s"${res._1} ${res._2}")
  }
}
