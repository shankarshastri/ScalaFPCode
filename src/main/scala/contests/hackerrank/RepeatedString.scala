/**
  * @author ShankarShastri
  *         Algorithm: RepeatedString(https://www.hackerrank.com/challenges/repeated-string/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._
object RepeatedString {
  
  // Complete the repeatedString function below.
  def repeatedString(s: String, n: Long): Long = {
    val sLength = s.length.toLong
    val countOfA = s.count(_ == 'a')
    if(n % sLength  == 0) (n/sLength) * countOfA
    else {
      val diffL = n % sLength
      (n / sLength) * countOfA + s.substring(0, diffL.toInt).count(_ == 'a')
    }
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val s = stdin.readLine
    val n = stdin.readLine.trim.toLong
    val result = repeatedString(s, n)
    printWriter.println(result)
    printWriter.close()
  }
}