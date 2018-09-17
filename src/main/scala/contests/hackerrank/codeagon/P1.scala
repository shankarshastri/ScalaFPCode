/**
  * @author ShankarShastri
  *         Algorithm: P1
  */

package contests.hackerrank.codeagon

import scala.io.StdIn._
import scala.annotation.tailrec

object P1 {
  def readLineToList(str: String = readLine) = str.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
  
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
  
  def loopWithReadLine[T](n: BigInt)(block: String => T): Unit =
    (BigInt(1) to n).map(_ => {
      println(block(readLine))
    })
  
  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    loop(t) {
        val List(x1,y1) = readLine.split(" ").map(_.toInt).toList
        val List(x2,y2) = readLine.split(" ").map(_.toInt).toList
        val List(x3,y3) = readLine.split(" ").map(_.toInt).toList
        val List(x4,y4) = readLine.split(" ").map(_.toInt).toList
        val List(x5,y5) = readLine.split(" ").map(_.toInt).toList
        
        
        
      }
    }
}
