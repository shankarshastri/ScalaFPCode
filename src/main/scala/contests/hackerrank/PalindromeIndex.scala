/**
  * @author ShankarShastri
  *         Algorithm: PalindromeIndex
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._

import scala.annotation.tailrec

object PalindromeIndex {
  @tailrec
  def palindromeCheck(s: String, index: Int=  0): Int = {
    println(s)
    if(s.isEmpty) index
    else {
      val str = s.substring(0, index) + s.substring(index+1, s.length)
      if(str.reverse == str) palindromeCheck("", index)
      else palindromeCheck(s, index+1)
    }
  }
  
  
  // Complete the palindromeIndex function below.
  def palindromeIndex(s: String): Int = {
    if(s == s.reverse) -1 else palindromeCheck(s)
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(System.out)
    val q = stdin.readLine.trim.toInt
    for (qItr <- 1 to q) {
      val s = stdin.readLine
      val result = palindromeIndex(s)
      printWriter.println(result)
    }
    printWriter.close()
  }
}
