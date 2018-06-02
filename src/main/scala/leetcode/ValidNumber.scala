/**
  * @author ShankarShastri
  *         Algorithm: ValidNumber (https://leetcode.com/problems/valid-number/)
  */

package leetcode

import scala.io.StdIn._

object ValidNumber {

  import scala.util.{Failure, Success, Try}


  def main(args: Array[String]): Unit = {
    isNumber(readLine)
  }

  def isNumber(s: String): Boolean = {
    val bigDecBool = Try(BigDecimal(s.trim)) match {
      case Success(_) => true
      case Failure(_) => false
    }
    val doubleBool = Try(s.trim.toDouble) match {
      case Success(_) => {
        if (s.trim.contains("f") || s.trim.contains("D")) false else true
      }
      case Failure(_) => false
    }
    (bigDecBool || doubleBool)
  }
}
