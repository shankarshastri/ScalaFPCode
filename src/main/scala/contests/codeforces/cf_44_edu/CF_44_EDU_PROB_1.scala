/**
  * @author ShankarShastri
  *         Algorithm: CF_EDU_44_1 (http://codeforces.com/contest/985/problem/A)
  */

package contests.codeforces.cf_44_edu

import scala.io.StdIn._

object CF_44_EDU_PROB_1 {
  def main(args: Array[String]): Unit = {
    val n = readInt
    val arr = readLine.split(" ").map(_.toInt).toList.sorted
    val computedBlackList = (1 to n).filter(_ % 2 == 1).toList
    val computedWhiteList = (1 to n).filter(_ % 2 == 0).toList
    println(Math.min(subtractList(arr, computedBlackList).sum, subtractList(arr, computedWhiteList).sum))
  }

  def subtractList(list1: List[Int], list2: List[Int]) = {
    (list1 zip list2).map(x => Math.abs(x._1 - x._2))
  }

}
