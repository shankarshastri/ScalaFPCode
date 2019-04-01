/**
  * @author ShankarShastri
  *         Algorithm: SuperiorString
  */

package contests.hackerearth

import scala.io.StdIn._
import scala.annotation.tailrec

object SuperiorString {
  
  def loopAndPrintResult[T](n: Int)(block: => T): Unit =
    (1 to n).map(_ => {
      println(block)
    })
  
  def supStringLen(s: String): Int = {
    if(s.distinct == s) {
      (s.length / 2) + 1
    } else {
      val m = s.foldLeft(Map[Char, Int]())((a,b) => a.updated(b, a.getOrElse(b, 0) + 1))
      val r = m.maxBy(_._2)
      s.indexOf(r._1) + r._2 * 2
    }
  }
  
  def main(args: Array[String]): Unit = {
    val t = readInt
    loopAndPrintResult(t) {
      readLine
      val s = readLine
      supStringLen(s)
    }
  }
}
