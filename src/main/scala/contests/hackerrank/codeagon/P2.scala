/**
  * @author ShankarShastri
  *         Algorithm: P2
  */

package contests.hackerrank.codeagon

import scala.io.StdIn._
import scala.annotation.tailrec

/**
  * @author ShankarShastri
  *         Algorithm: P1
  */



object P2 {
  def readLineToList(str: String = readLine) = str.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
  
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
  
  def loopWithReadLine[T](n: BigInt)(block: String => T): Unit =
    (BigInt(1) to n).map(_ => {
      println(block(readLine))
    })
  
  def main(args: Array[String]): Unit = {
  
  }
}

