/**
  * @author ShankarShastri
  *         Algorithm: PE38
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object PE38 {
  
  def checkPandigital(s: String, k: String): Boolean = {
    s.distinct.sorted == k
  }
  
  def main(args: Array[String]): Unit = {
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val r = (1 to k).map(_.toString).mkString
    val res = for {
      i <- 2 to n
      s = (1 to 6).foldLeft((i, ""))((a,b) => {
        if((a._2 + a._1 * b).length <= k)
          (a._1, a._2 + a._1 * b)
        else a
      })._2
      if checkPandigital(s, r)
    } yield i
    println(res.mkString("\n"))
  }
}
