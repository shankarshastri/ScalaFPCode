/**
  * @author Shankar Shastri
  *         *
  *         Algorithm: Anagram Strings
  */
package algorithm

import scala.io.StdIn._

object AnagramStrings {

  def main(args: Array[String]): Unit = {
    val s1 = readLine
    val s2 = readLine

    println(isAnagram(s1, s2))
  }

  /**
    * Anagram Verifier
    *
    * @param s1 String
    * @param s2 String
    * @return Boolean
    */
  def isAnagram(s1: String, s2: String): Boolean = s1.sorted == s2.sorted

}
