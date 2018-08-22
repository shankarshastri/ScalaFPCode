/**
  * @author ShankarShastri
  *         Algorithm: LargeSum (https://www.hackerrank.com/contests/projecteuler/challenges)
  */

package contests.project_euler

import scala.io.StdIn.readLine

object LargeSum {
  def main(args: Array[String]) {
    val n = scala.io.StdIn.readInt
    val lSum = (1 to n).foldLeft(BigInt(0))((a,_) => {
      val num = BigInt(readLine)
      a+ num
    })
    println(lSum.toString.take(10))
  }
}