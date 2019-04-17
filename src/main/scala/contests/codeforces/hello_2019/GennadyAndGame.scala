/**
  * @author ShankarShastri
  *         Algorithm: GennadyAndGame
  */

package contests.codeforces.hello_2019

import scala.io.StdIn._
import scala.annotation.tailrec

object GennadyAndGame {
  def main(args: Array[String]): Unit = {
    val l = readLine
    val listOfCards = readLine.split(" ").toList
    val r = listOfCards.foldLeft(false)((a,b) => b.contains(l.charAt(0)) || b.contains(l.charAt(1)) || a)
    if(r) println("YES") else println("NO")
  }
}
