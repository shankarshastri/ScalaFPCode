/**
  * @author ShankarShastri
  * Algorithm: StoneGame (https://leetcode.com/problems/stone-game/description/)
  */

package leetcode

import scala.io.StdIn._
import scala.annotation.tailrec

import scala.annotation.tailrec
object SolutionX {
  def max(x: BigInt, y: BigInt): BigInt = {
    if(x > y) x else y
  }
  
  
  def maxOf3(x: BigInt, y: BigInt, z: BigInt): BigInt = {
    if(x >= y && x >= z) x
    else if(y>=z && y>=x) y
    else z
  }
  
  
  def minOf3(x: BigInt, y: BigInt, z: BigInt): BigInt = {
    if(x <= y && x <= z) x
    else if(y<=z && y<=x) y
    else z
  }
  
  @tailrec
  def stoneGameL(l: List[BigInt], aValue: BigInt = 0, lValue: BigInt = 0, index: BigInt = 0): Boolean = {
    l match {
      case Nil => (aValue > lValue)
      case head :: Nil =>
        if(index % 2 == 0) {
          stoneGameL(Nil, aValue + head, lValue, index+1)
        } else {
          stoneGameL(Nil, aValue, lValue + head, index+1)
        }
      case  head :: last :: Nil =>
        if(index % 2 == 0) {
          if (max(head, last) == head) {
            stoneGameL(last :: Nil, aValue + head, lValue, index+1)
          } else {
            stoneGameL(head :: Nil, aValue + last, lValue, index+1)
          }
        } else {
          if (max(head, last) != head) {
            stoneGameL(last :: Nil, aValue, lValue + head, index+1)
          } else {
            stoneGameL(head :: Nil, aValue, lValue + last, index+1)
          }
        }
      case head :: (tail :+ last)=>
        if(index % 2 == 0) {
          if (maxOf3(head, tail.head, last) == head) {
            stoneGameL(tail, aValue + head, lValue, index + 1)
          } else if (maxOf3(head, tail.head, last) == tail.head) {
            stoneGameL(head :: tail.tail, aValue + tail.head, lValue, index + 1)
          } else {
            stoneGameL(head :: tail.init, aValue + last, lValue, index + 1)
          }
        } else {
          if (minOf3(head, tail.head, last) == head) {
            stoneGameL(tail, aValue, lValue + head, index + 1)
          } else if (minOf3(head, tail.head, last) == tail.head) {
            stoneGameL(head :: tail.tail, aValue, lValue + tail.head, index + 1)
          } else {
            stoneGameL(head :: tail.init, aValue, lValue + last, index + 1)
          }
        }
    }
  }
  def stoneGame(piles: Array[Int]): Boolean = {
    stoneGameL(piles.map(BigInt(_)).toList)
  }
}

object StoneGame {
  def main(args: Array[String]): Unit = {
    val x = Array[Int](5,3,4,5)
    SolutionX.stoneGame(x)
  }
}
