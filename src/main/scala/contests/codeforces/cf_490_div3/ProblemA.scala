/**
  * @author ShankarShastri
  *         Algorithm: ProblemA(http://codeforces.com/contest/999/problem/A)
  */

package contests.codeforces.cf_490_div3

import scala.io.StdIn._


object ProblemA {
  def solveContestForMiska(list: List[Int], k: Int) = {
    val leftList =  list.takeWhile(_ <= k)
    leftList.length + list.splitAt(leftList.length)._2.reverse.takeWhile(_ <= k).length
  }
  def readLineToList[Int]() = readLine.split(" ").map(_.toInt).toList
  def main(args: Array[String]): Unit = {
   val Array(n,k) = readLine.split(" ").map(_.toInt)
    val list = readLineToList()
    println(solveContestForMiska(list, k))
  }
}
