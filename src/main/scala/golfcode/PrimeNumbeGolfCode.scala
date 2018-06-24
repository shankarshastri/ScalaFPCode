/**
  * @author ShankarShastri
  *         Algorithm: PrimeNumbeGolfCode
  */

package golfcode

import scala.io.StdIn._

object PrimeNumbeGolfCode {
  def readLineToList = readLine.split(" ").map(_.toInt).toList

  def f(n:Int)= !(2 to n-1).exists(n%_==0)

  def main(args: Array[String]): Unit = {
    val n = 103
    f(n)
  }
}
