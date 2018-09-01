/**
  * @author ShankarShastri
  *         Algorithm: CustomizedChess (https://www.hackerrank.com/contests/hourrank-29/challenges/customized-chess-board/problem)
  */

package contests.hackerrank

import java.io._
import scala.io._

object CustomizedChess {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val t = StdIn.readLine.trim.toInt
    for (tItr <- 1 to t) {
      val n = StdIn.readLine.trim.toInt
      val board = Array.ofDim[Int](n, n)
      for (i <- 0 until n) {
        board(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      }
      val result = solve(board)
      printWriter.println(result)
    }
    printWriter.close()
  }
  
  // Complete the solve function below.
  def solve(board: Array[Array[Int]]): String = {
    checkChessBoard(board) match {
      case true => "Yes"
      case _ => "No"
    }
  }
  
  def checkChessBoard(a: Array[Array[Int]]): Boolean = {
    a.forall(b => checkChessBoardLine(b.toList))
  }
  
  def checkChessBoardLine(list: List[Int]): Boolean = {
    val splitLists = list.zipWithIndex.partition(_._2 % 2 == 0)
    splitLists._1.count(_._1 == list.head) == splitLists._1.length &&
      splitLists._2.count(_._1 != list.head) == splitLists._2.length
  }
}
