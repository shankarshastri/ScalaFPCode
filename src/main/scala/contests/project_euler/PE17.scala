/**
  * @author ShankarShastri
  *         Algorithm: PE17(https://www.hackerrank.com/contests/projecteuler/challenges/euler017)
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object PE17 {
  
  def loopWithRes[T](n: Int)(block: => T): List[T] = (1 to n).map(_ => block).toList
  
  def numToWords(i: String): String = {
    val listFrom1To10 = List("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")
    val listFrom11to19 = List("Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val listFrom30to90By10 = List("Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    val mapFrom1To10 = ((1 to 10) zip listFrom1To10).map(e => e).toMap
    val mapFrom11To19 = ((11 to 19) zip listFrom11to19).map(e => e).toMap
    val mapFrom30to90By10 = ((20 to 90 by 10) zip listFrom30to90By10).map(e => e).toMap
    
    val map = mapFrom1To10 ++ mapFrom11To19 ++ mapFrom30to90By10
    val reverseMap = map.map(e => (e._2, e._1))
    val mapFrom31to99 = listFrom30to90By10.flatMap(e1 => listFrom1To10.init.map(e => {
      val t =   reverseMap.getOrElse(e1, 0)
      val u = reverseMap.getOrElse(e, 0)
      (t+u, s"${e1} ${e}")
    })).toMap
    
    val hToBIntList = List(100, 1000, 1000000, 1000000000)
    val hToBList = List("Hundred", "Thousand", "Million", "Billion")
    val hToBMap = (hToBIntList zip hToBList).map(e => e).toMap
    
    val totalMap = (map ++ mapFrom31to99 ++ hToBMap + (0 -> "")).map(e => (BigInt(e._1), e._2))
    
    def numToWord(i: BigInt):String = {
      i match {
        case i if totalMap.isDefinedAt(i) => totalMap(i)
        case i if i > 99 && i <= 999 => totalMap(i / 100) + " " + totalMap(100) + " " + totalMap(i % 100)
        case i if i > 999 && i <= 999999 => numToWord(i / 1000) + " " + totalMap(1000) + " " + numToWord(i % 1000)
        case i if i > 99999 && i <= 999999999 => numToWord(i / 1000000) + " " + totalMap(1000000) + " " + numToWord(i % 1000000)
        case i  if i > 999999999 => numToWord(i / 1000000000) + " " + totalMap(1000000000) + " " + numToWord(i % 1000000000)
        case _ => ""
      }
    }
    
    numToWord(BigInt(i))
  }
  
  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    loopWithRes[Unit](t) {
      val n = readLine
      println(numToWords(n))
    }
  }
}
