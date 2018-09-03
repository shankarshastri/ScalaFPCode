/**
  * @author ShankarShastri
  *         Algorithm: ClosestNumbers (https://www.hackerrank.com/challenges/closest-numbers/problem)
  */

package contests.hackerrank

import java.io._


object ClosestNumbers {
  def closestNumbers(l: Array[Int]): Array[Int] = {
    val res = l.toList.sorted.sliding(2).toList
      .map(e =>(e.head, e.tail.head, Math.abs(e.head - e.tail.head)))
      .sortWith((a, b) => a._3 < b._3)
    res.takeWhile(e => e._3 == res.head._3)
      .flatMap(e => List(e._1, e._2)).toArray
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val n = stdin.readLine.trim.toInt
    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = closestNumbers(arr)
    printWriter.println(result.mkString(" "))
    printWriter.close()
  }
}

