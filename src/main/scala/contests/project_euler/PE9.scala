/**
  * @author ShankarShastri
  *         Algorithm: PE9
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object PE9 {
  
  import scala.io.StdIn._
  
  def loopWithReadLine[T](n: BigInt)(block: String => T): Unit =
    (BigInt(1) to n).map(_ => {
      println(block(readLine))
    })
  
  def main(args: Array[String]) {
    val t = readLine
    loopWithReadLine(BigInt(t)) {
      e => {
      
      }
    }
  }
}