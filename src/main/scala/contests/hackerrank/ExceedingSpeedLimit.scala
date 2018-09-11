/**
  * @author ShankarShastri
  *         Algorithm: ExceedingSpeedLimit
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec
import scala.io.StdIn



object ExceedingSpeedLimit {
  def solve(s: Int): Unit = {
    s match {
      case n if n <=90 => println("0 No punishment")
      case n if n >90 && n<=110 => println(s"${(n-90)*300} Warning")
      case n => println(s"${(n-90)*500} License removed")
    }
  }
  
  def main(args: Array[String]) {
    val s = StdIn.readLine.trim.toInt
    solve(s)
  }
}
