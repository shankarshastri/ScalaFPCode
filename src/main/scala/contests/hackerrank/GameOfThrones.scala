/**
  * @author ShankarShastri
  *         Algorithm: GameOfThrones
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._

object GameOfThrones {
  def canConstructPalindrome(s: String): Boolean = {
    val sDistinct = s.distinct
    val map = sDistinct.map(e => (e, s.count(_ == e))).toMap
    val mapFilterSize =  map.filter(_._2 % 2 == 0).size
    val mapSize = map.size
    (mapFilterSize == mapSize) || (mapFilterSize == mapSize - 1)
  }
  
  // Complete the gameOfThrones function below.
  def gameOfThrones(s: String): String = {
    canConstructPalindrome(s) match {
      case true => "YES"
      case _ => "NO"
    }
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env(System.out))
    val s = stdin.readLine
    val result = gameOfThrones(s)
    printWriter.println(result)
    printWriter.close()
  }
}

