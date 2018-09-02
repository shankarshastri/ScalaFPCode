/**
  * @author ShankarShastri
  *         Algorithm: AppleAndOrange(https://www.hackerrank.com/challenges/apple-and-orange/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object AppleAndOrange {
  
  // Complete the countApplesAndOranges function below.
  def countApplesAndOranges(s: Int, t: Int, a: Int, b: Int,
                            apples: Array[Int], oranges: Array[Int]) {
    val noOfApples = apples.filter(e => {
      val d = a+e
      (d<=t) && (d>=s)
    }).length
    val noOfOranges = oranges.filter(e => {
      val d = b+e
      (d<=t) && (d>=s)
    }).length
    println(noOfApples)
    println(noOfOranges)
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val st = stdin.readLine.split(" ")
    val s = st(0).trim.toInt
    val t = st(1).trim.toInt
    val ab = stdin.readLine.split(" ")
    val a = ab(0).trim.toInt
    val b = ab(1).trim.toInt
    val mn = stdin.readLine.split(" ")
    val m = mn(0).trim.toInt
    val n = mn(1).trim.toInt
    val apples = stdin.readLine.split(" ").map(_.trim.toInt)
    val oranges = stdin.readLine.split(" ").map(_.trim.toInt)
    countApplesAndOranges(s, t, a, b, apples, oranges)
  }
}
