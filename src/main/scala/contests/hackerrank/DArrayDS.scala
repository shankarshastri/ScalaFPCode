/**
  * @author ShankarShastri
  *         Algorithm: DArrayDS (https://www.hackerrank.com/challenges/2d-array/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._

object HourGlass {
  
  def hourglassSum(arr: Array[Array[Int]]): Int = {
    val l = for {
      i <- 0 to arr.length-3
      j <- 0 to arr.length-3
    } yield {
      arr(i)(j) + arr(i)(j+1) + arr(i)(j+2) +
        arr(i+1)(j+1) + arr(i+2)(j)+arr(i+2)(j+1) + arr(i+2)(j+2)
    }
    l.max
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val arr = Array.ofDim[Int](6, 6)
    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }
    val result = hourglassSum(arr)
    printWriter.println(result)
    printWriter.close()
  }
}
