/**
  * @author ShankarShastri
  *         Algorithm: TwoStrings (https://www.hackerrank.com/challenges/two-strings/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._

object TwoStrings {
  
  // Complete the twoStrings function below.
  def twoStrings(s1: String, s2: String): String = {
    val distinctS2 = s2.distinct
    s1.distinct.exists(e => distinctS2.exists(_ == e)) match {
      case true => "YES"
      case _ => "NO"
    }
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val q = stdin.readLine.trim.toInt
    for (qItr <- 1 to q) {
      val s1 = stdin.readLine
      val s2 = stdin.readLine
      val result = twoStrings(s1, s2)
      printWriter.println(result)
    }
    printWriter.close()
  }
}

