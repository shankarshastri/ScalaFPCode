/**
  * @author ShankarShastri
  *         Algorithm: PrintProgram
  */

package golfcode

import scala.io.StdIn._
import scala.annotation.tailrec

object PrintProgram {
  def readLineToList = readLine.split(" ").map(_.toInt).toList

  def main(args:Array[String]) = {
    println(s"""object x{def main(a:Array[String])=println("+${args.mkString}")}""")
  }
}
