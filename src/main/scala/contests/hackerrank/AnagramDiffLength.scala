/**
  * @author ShankarShastri
  *         Algorithm: AnagramDiffLength (https://www.hackerrank.com/challenges/anagram/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec



import java.io._

object AnagramDiffLength {
  
  // Complete the anagram function below.
  def anagram(s: String): Int = {
    s.length % 2 == 0 match {
      case true =>
        val splitStr = s.splitAt(s.length/2)
        splitStr._1.diff(splitStr._2).length
      case _ => -1
    }
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    
    val q = stdin.readLine.trim.toInt
    
    for (qItr <- 1 to q) {
      val s = stdin.readLine
      
      val result = anagram(s)
      
      printWriter.println(result)
    }
    
    printWriter.close()
  }
}

