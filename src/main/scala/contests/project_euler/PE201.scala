/**
  * @author ShankarShastri
  *         Algorithm: PE201
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object PE201 {
  
  def subsetWithUniqueSum(s: Set[Long], n: Int) = {
    val res = s.subsets(n).map(_.sum).toList
    val distRes = res.distinct
    distRes.diff(res.diff(distRes)).sum
  }
  
  def main(args: Array[String]): Unit = {
    val Array(n, k) = readLine.split(" ").map(_.toInt)
    val s = readLine().split(" ").map(_.toLong).toSet
    println(subsetWithUniqueSum(s, k))
  }
}
