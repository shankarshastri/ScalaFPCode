/**
  * @author ShankarShastri
  *         Algorithm: FibWords
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object FibWords {
  
  def fibWords(a: String, b: String, l: BigInt, res: String = ""): Char = {
    if(res.length > l) {
      res.charAt(l.toInt - 1)
    } else {
      fibWords(b, a+b, l,  a+b)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    (1 to t).foreach{
      _ => {
        val Array(a,b,s) = readLine.split(" ")
        println(fibWords(a, b, BigInt(s)))
      }
    }
  }
}
