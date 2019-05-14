/**
  * @author ShankarShastri
  *         Algorithm: MaxCostArrPairs
  *         (https://www.geeksforgeeks.org/find-the-maximum-cost-of-an-array-of-pairs-choosing-at-most-k-pairs/)
  */

package contests.geeksforgeeks

import scala.io.StdIn._
import scala.annotation.tailrec

object MaxCostArrPairs {
  
  def maxCostArrPairs(l: List[(Int, Int)]): Int = {
    l.sortWith((a,b) => a._2 > b._2).sliding(4)
      .map(e => e.map(_._1).sum * e.map(_._2).min)
      .max
  }
  
  def main(args: Array[String]): Unit = {
    val l = List((62,21), (31,16), (19,2), (32,19), (12, 17))
    println(maxCostArrPairs(l))
  }
}
