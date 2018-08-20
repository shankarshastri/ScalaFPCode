/**
  * @author ShankarShastri
  *         Algorithm: DiagonalSum(https://www.hackerrank.com/challenges/diagonal-difference/problem)
  */
package contests.hackerrank

import java.io._

object DiagonalSum {
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    
    val n = stdin.readLine.trim.toInt
    
    val arr = Array.ofDim[Int](n, n)
    
    for (i <- 0 until n) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }
    
    val result = diagonalDifference(arr)
    
    printWriter.println(result)
    
    printWriter.close()
  }
  
  // Complete the diagonalDifference function below.
  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    val start = 0
    val end = arr.length
    
    val aDiagonal = ((start until end) zip (start until end)).map(e => e)
    val bDiagonal = ((start until end) zip (end - 1 to start by -1)).map(e => e)
    
    val aDiagonalSum = aDiagonal.map(e => arr(e._1)(e._2)).sum
    val bDiagonalSum = bDiagonal.map(e => arr(e._1)(e._2)).sum
    Math.abs(aDiagonalSum - bDiagonalSum)
  }
}
