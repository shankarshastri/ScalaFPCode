package programming

import scala.io.StdIn._

object Nqueen {
  
  // Picked From Here => https://gist.github.com/pathikrit/6fa878fe87c6160a52c4c27dabbfa6df
  /**
    * Solves the n-Queen puzzle in O(n!)
    * Let p[r] be the column of the queen on the rth row (must be exactly 1 queen per row)
    * There also must be exactly 1 queen per column and hence p must be a permutation of (0 until n)
    * There must be n distinct (col + diag) and n distinct (col - diag) for each queen (else bishop attacks)
    * @return Vector p of length n such that p[i] is the column of the queen on the ith row in a solution
    *
    */
  def nQueens(n: Int):List[IndexedSeq[Int]] = ((0 until n).permutations filter {p =>
    p.zipWithIndex.flatMap{case (c, d) => Seq(n + c + d, c - d)}.distinct.size == 2*n
  }).toList
  
  def main(args: Array[String]):Unit = {
    val size: Int = readLine.toInt
    nQueens(size).zipWithIndex foreach {case (solution, num) =>
      println(s"Solution #${num + 1}:")
      val rows = solution.map(col => solution.indices.map(i => if (i == col) 'Q' else '-').mkString)
      rows foreach println
    }
  }
}