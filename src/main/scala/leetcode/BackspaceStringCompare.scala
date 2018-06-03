/**
  * @author ShankarShastri
  *         Algorithm: BackspaceStringCompare (https://leetcode.com/problems/backspace-string-compare/)
  */
package leetcode

import scala.annotation.tailrec
import scala.io.StdIn._

object BackspaceStringCompare {

  def ltrim(s: String) = s.dropWhile(_ == '#')

  @tailrec
  def backSpaceRemover(str: String): String = {
    if (!str.contains("#")) ltrim(str)
    else {
      val trimmedString = ltrim(str)
      val indexOf = trimmedString.indexOf('#')
      if (indexOf != -1) {
        backSpaceRemover(
          trimmedString.substring(0, indexOf - 1) +
            trimmedString.substring(indexOf + 1))
      } else ltrim(str)
    }
  }

  def backspaceCompare(S: String, T: String): Boolean = {
    backSpaceRemover(S) == backSpaceRemover(T)
  }

  def main(args: Array[String]): Unit = {
    backspaceCompare(readLine, readLine)
  }
}
