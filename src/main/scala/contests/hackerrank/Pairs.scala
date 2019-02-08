/**
  * @author ShankarShastri
  *         Algorithm: Pairs (https://www.hackerrank.com/challenges/pairs/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._

object Solution {
  
  // Complete the pairs function below.
  def pairs(k: Int, arr: Array[Int]): Int = {
    val map = arr.map((_, true)).toMap.withDefaultValue(false)
    arr.count(e => map.isDefinedAt(e + k))
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val nk = stdin.readLine.split(" ")
    val n = nk(0).trim.toInt
    val k = nk(1).trim.toInt
    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = pairs(k, arr)
    printWriter.println(result)
    printWriter.close()
  }
}

