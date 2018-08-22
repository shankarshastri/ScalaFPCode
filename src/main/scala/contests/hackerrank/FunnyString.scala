/**
  * @author ShankarShastri
  *         Algorithm: FunnyString (https://www.hackerrank.com/challenges/funny-string/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._

object FunnyString {
  
  def isFunnyString(s: String): List[Int] = {
    s.map(_.toInt).sliding(2).toList
      .map(e => Math.abs(e.head - e.tail.head))
  }
  
  def funnyString(s: String): String = {
    (isFunnyString(s) ==  isFunnyString(s.reverse)) match {
      case true => "Funny"
      case _ => "Not Funny"
    }
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    
    val q = stdin.readLine.trim.toInt
    
    for (qItr <- 1 to q) {
      val s = stdin.readLine
      
      val result = funnyString(s)
      
      printWriter.println(result)
    }
    
    printWriter.close()
  }
}

