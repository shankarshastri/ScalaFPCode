/**
  * @author ShankarShastri
  *         Algorithm: AngryProfessor (https://www.hackerrank.com/challenges/angry-professor/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._

object Solution {
  
  def boolToStringRes(b: Boolean, trueStr: String,
                      falseStr: String): String = {
    b match {
      case true => trueStr
      case _ => falseStr
    }
  }
  
  def angryProfessor(k: Int, a: Array[Int]): String = {
    boolToStringRes(a.count(_ <= 0) >= k, "NO", "YES")
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val t = stdin.readLine.trim.toInt
    for (tItr <- 1 to t) {
      val nk = stdin.readLine.split(" ")
      val n = nk(0).trim.toInt
      val k = nk(1).trim.toInt
      val a = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = angryProfessor(k, a)
      printWriter.println(result)
    }
    printWriter.close()
  }
}