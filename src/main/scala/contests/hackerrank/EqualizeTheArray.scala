/**
  * @author ShankarShastri
  *         Algorithm: EqualizeTheArray (https://www.hackerrank.com/challenges/equality-in-a-array/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._
object EqualizeTheArray {
  
  def equalizeArray(arr: Array[Int]): Int = {
    val l = arr.toList
    val distinctL = l.distinct
    val max = distinctL.map(e => l.count(_ == e)).max
    l.length - max
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val n = stdin.readLine.trim.toInt
    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = equalizeArray(arr)
    printWriter.println(result)
    printWriter.close()
  }
}