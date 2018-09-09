/**
  * @author ShankarShastri
  *         Algorithm: ArrayManipulation
  */
package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import java.io._
object ArrayManipulation {

  // Complete the arrayManipulation function below.
  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    val arr = Array.fill(n + 1)(BigInt(0))
    queries.foreach { e =>
      {
        val Array(a, b, k) = e
        arr.update(a, arr(a) + k)
        if (b + 1 <= n)
          arr.update(b + 1, arr(b + 1) - k)
      }
    }
    arr
      .foldLeft(BigInt(0), BigInt(0))((a, b) => {
        (a._1 + b, a._2.max(a._1 + b))
      })
      ._2
      .longValue
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(System.out)
    val nm = stdin.readLine.replaceAll("\\s+$", "") split (" ")
    val n = nm(0).trim.toInt
    val m = nm(1).trim.toInt
    val queries = Array.ofDim[Int](m, 3)
    for (i <- 0 until m) {
      queries(i) =
        stdin.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }
    val result = arrayManipulation(n, queries)
    printWriter.println(result)
    printWriter.close()
  }
}
