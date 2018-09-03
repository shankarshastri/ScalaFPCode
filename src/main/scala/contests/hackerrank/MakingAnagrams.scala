/**
  * @author ShankarShastri
  *         Algorithm: MakingAnagrams (https://www.hackerrank.com/challenges/making-anagrams/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._
object MakingAnagrams {
  
  def createCharCountMap(s: String): Map[Char, Int] = {
    val distinctS = s.distinct
    distinctS.map(e => (e, s.count(_ == e))).toMap.withDefaultValue(0)
  }
  
  def getCharCountDiff(a: Map[Char, Int], b: Map[Char, Int]): Int = {
    (97 to 122).map(e => {
      Math.abs(a(e.toChar) - b(e.toChar))
    }).sum
  }
  
  def makingAnagrams(s1: String, s2: String): Int = {
    getCharCountDiff(createCharCountMap(s1) , createCharCountMap(s2))
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val s1 = stdin.readLine
    val s2 = stdin.readLine
    val result = makingAnagrams(s1, s2)
    printWriter.println(result)
    printWriter.close()
  }
}
