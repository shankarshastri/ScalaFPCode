/**
  * @author ShankarShastri
  *         Algorithm: BankAccounts
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object codeOpsBankAccounts {
  def readLineToList(str: String = readLine) = str.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
  
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
}

object BankAccounts {
  import codeOpsBankAccounts._
  def main(args: Array[String]): Unit = {
    val q = readLine().toInt
    loop(q) {
      val List(_, k, x, d) = readLineToList().map(_.toDouble)
      val s = readLineToList().map(e => Math.max((x * e)/100, k)).sum
      println(s)
      if(s > d) println("upfront") else println("fee")
    }
  }
}
