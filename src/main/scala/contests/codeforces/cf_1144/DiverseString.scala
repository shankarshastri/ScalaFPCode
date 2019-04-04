/**
  * @author ShankarShastri
  *         Algorithm: DiverseString (http://codeforces.com/contest/1144/problem/A)
  */

package contests.codeforces.cf_1144

import scala.io.StdIn._
import scala.annotation.tailrec

object DiverseString {
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    val alphaStr = "abcdefghijklmnopqrstuvwxyz"
    loop(t) {
      val s = readLine.sorted
      if (s.length > 26) {
        println("No")
      } else {
        s.headOption match {
          case None => println("No")
          case Some(l) =>
            alphaStr.indexOf(l) match {
              case e if (e + s.length > 26) => println("No")
              case e if (s.diff(alphaStr.substring(e, (e + s.length))).length == 0 && e != -1) => println("Yes")
              case _ => println("No")
            }
        }
      }
    }
  }
}
