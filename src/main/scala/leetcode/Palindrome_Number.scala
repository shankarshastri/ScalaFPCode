/**
  * @author ShankarShastri
  *         Algorithm: Palindrome_Number (https://leetcode.com/problems/palindrome-number/description/)
  */

package leetcode

import scala.io.StdIn._
import scala.annotation.tailrec

object Palindrome_Number {

  def isPalindrome(x: Int): Boolean = {
    val xStr = x.toString
    (xStr == xStr.reverse)
  }

  def main(args: Array[String]): Unit = {

  }
}
