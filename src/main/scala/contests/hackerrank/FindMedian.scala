/**
  * @author ShankarShastri
  *         Algorithm: FindMedian(https://www.hackerrank.com/challenges/find-the-median/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._


object FindMedian {
  
  def findMedian(arr: Array[Int]): Int = {
    val sortedL = arr.sorted
    sortedL((arr.length/2))
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val n = stdin.readLine.trim.toInt
    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = findMedian(arr)
    printWriter.println(result)
    printWriter.close()
  }
}
