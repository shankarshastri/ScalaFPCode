/**
  * @author ShankarShastri
  *         Algorithm: AddLargeNumber
  */
package algorithm

import scala.annotation.tailrec
import scala.io.StdIn._

object AddLargeNumber {
  def main(args: Array[String]): Unit = {
    val s1 = readLine
    val s2 = readLine
    println(addString(s1, s2))
  }

  /**
    *
    * @param s1
    * @param s2
    * @return
    */
  def addString(s1: String, s2: String): String = {
    @tailrec
    def addStringCompute(s1: String,
                         s2: String,
                         sumString: String = "",
                         carry: Int = 0): String = {
      if (s1.length == 1 && s2.length == 1) {
        val sum = (s1.head.toString.toInt + s2.head.toString.toInt
          + carry.toInt).toString
        sum + sumString
      } else {
        val str = (s1.head.toString.toInt +
          s2.head.toString.toInt + carry.toInt).toString
        val (sumStr, carryStr) = (str.init, str.last)
        if (sumStr == "") {
          addStringCompute(s1.tail, s2.tail, carryStr + sumString, 0)
        } else {
          addStringCompute(s1.tail, s2.tail, carryStr + sumString, sumStr.toInt)
        }
      }
    }

    val maxLength = Math.max(s1.length, s2.length)
    val preparedS1 = ("0" * (maxLength - s1.length) + s1).reverse
    val preparedS2 = ("0" * (maxLength - s2.length) + s2).reverse
    addStringCompute(preparedS1, preparedS2)
  }
}
