/**
  * @author ShankarShastri
  *         Algorithm: ReverseInteger (https://leetcode.com/problems/reverse-integer/)
  */

package leetcode

import scala.io.StdIn._
import scala.util.Try

object ReverseInteger {
  def main(args: Array[String]): Unit = {
    println(reverse(readInt))
  }

  def reverse(x: Int): Int = {
    val xReverse = x.toString.reverse
    Try {
      if (x < 0) {
        xReverse.init.toInt * -1
      } else {
        xReverse.toInt
      }
    }.getOrElse(0)
  }
}

//
//object Solution {
//  def bigIntToString(x: String) = {
//    if(x.last == '-') BigInt(x.init)
//    else BigInt(x)
//  }
//
//  def reverse(x: Int):Int = {
//    val res = bigIntToString(x.toString.reverse).toInt
//    if(res.isValidInt && x < 0) res * -1
//    else res
//  }
//}