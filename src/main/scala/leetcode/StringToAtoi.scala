/**
  * @author ShankarShastri
  *         Algorithm: StringToAtoi (https://leetcode.com/problems/string-to-integer-atoi/)
  */

package leetcode

import scala.annotation.tailrec
import scala.io.StdIn._
import scala.util.Try

object StringToAtoi {

  val getCharValidNumber: PartialFunction[Char, Char] = {
    case ch: Char if ch.toInt >= 48 && ch.toInt <= 57 => ch
    case ch: Char if ch == '-' => '-'
    case ch: Char if ch == '+' => '+'
    case ch: Char if ch == ' ' || ch == '_' => '_'
    case _: Char => '$'
  }


  val isCharValidNumber: PartialFunction[Char, Boolean] = {
    case ch: Char if ch.toInt >= 48 && ch.toInt <= 57 => true
    case ch: Char if ch == '-' || ch == '_' || ch == '+' => true
    case _: Char => false
  }

  val processValidCharNum: PartialFunction[Char, Boolean] = {
    case ch: Char if ch.toInt >= 48 && ch.toInt <= 57 => true
    case ch: Char if ch == '-' => true
    case _: Char => false
  }

  @tailrec
  def traverseConstructedString(str: String, constructedString: String = ""): String = {
    if (str.length == 0) {
      constructedString
    }
    else if (str.length == 1) {
      if (isCharValidNumber(str.head)) (str.head.toString + constructedString).reverse
      else constructedString.reverse
    } else {
      val head = str.head
      val tail = str.tail
      head match {
        case ch: Char
          if isCharValidNumber(ch) =>
          traverseConstructedString(str.tail, str.head.toString + constructedString)
        case _ => {
          constructedString.reverse
        }
      }
    }
  }

  @tailrec
  def processStringToNumber(str: String, accumString: String = "", index: Int = 0): String = {
    if (str.length == 0) "0"
    else if (str.length == 1) {
      if ((str.head == '-' || str.head == '+') && index == 0) accumString.reverse
      else if (str.head != '-' && str.head != '+' && processValidCharNum(str.head)) {
        (str.head + accumString).reverse
      } else {
        accumString.reverse
      }
    } else {
      str.head match {
        case ch: Char if (ch == '-' || ch == '+') && index == 0
          || (ch != '-' && ch != '+') && processValidCharNum(ch) =>
          processStringToNumber(str.tail, str.head + accumString, index + 1)
        case _: Char => accumString.reverse
      }
    }
  }

  def myAtoi(str: String): Int = {
    val strToTraverse = str.trim.map(x => getCharValidNumber(x))
    val constructedStr = traverseConstructedString(strToTraverse)
    val processedStr = processStringToNumber(constructedStr)
    val bigIntRepr = Try(BigInt(processedStr)).getOrElse(BigInt(0))
    if (bigIntRepr.isValidInt) {
      bigIntRepr.toInt
    } else {
      if (bigIntRepr > 0) Integer.MAX_VALUE
      else Integer.MIN_VALUE
    }
  }

  def main(args: Array[String]): Unit = {
    myAtoi(readLine)
  }
}
