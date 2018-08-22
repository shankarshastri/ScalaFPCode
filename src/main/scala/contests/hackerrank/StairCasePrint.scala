/**
  * @author ShankarShastri
  *         Algorithm: StairCasePrint
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object StairCasePrint {
  // Complete the staircase function below.
  def staircase(n: Int) {
    (1 to n).map(e => (e, n - e)).foreach(e => {
      val s = (1 to e._2).map(_ => " ")
        .mkString + (1 to e._1)
        .map(_ => "#").mkString
      println(s)
    })
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    staircase(n)
  }
}
