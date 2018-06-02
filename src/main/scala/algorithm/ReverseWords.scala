/**
  * @author Shankar Shastri
  *         *
  *         Algorithm: Reverse Words
  */
package algorithm

import scala.io.StdIn._

object ReverseWords {
  def main(args: Array[String]): Unit = {
    println(reverseWords(readLine))
  }

  /**
    *
    * @param str String
    * @return String
    */
  def reverseWords(str: String): String = {
    str.split(" ").reverse.mkString(" ")
  }

}
