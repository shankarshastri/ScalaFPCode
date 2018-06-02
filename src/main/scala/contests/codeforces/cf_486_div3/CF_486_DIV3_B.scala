/**
  * @author ShankarShastri
  *         Algorithm: CF_486_DIV3_B (http://codeforces.com/contest/988/problem/B)
  */

package contests.codeforces.cf_486_div3

import scala.annotation.tailrec
import scala.io.StdIn._

object CF_486_DIV3_B {

  @tailrec
  def subStringVerifier(list: List[String]): Boolean = {
    if (list.length == 0 || list.length == 1) true
    else if (list.length == 2) {
      if (list.last.contains(list.head)) true
      else false
    } else {
      list match {
        case head :: tail if tail.head.contains(head) => subStringVerifier(tail)
        case _ => false
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val n = readInt()

    val list = (1 to n).map { _ =>
      readLine
    }.toList
    val createdList = list.sortBy(_.length)
    if (subStringVerifier(createdList)) {
      println("YES")
      createdList.map(println)
    } else {
      println("NO")
    }
  }
}
