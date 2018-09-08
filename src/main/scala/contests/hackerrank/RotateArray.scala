/**
  * @author ShankarShastri
  *         Algorithm: RotateArray
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object RotateArray {
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val nd = stdin.readLine.split(" ")
    val n = nd(0).trim.toInt
    val d = nd(1).trim.toInt
    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val (p, q) = a.splitAt(d % n)
    println((q ++ p).mkString(" "))
  }
}
