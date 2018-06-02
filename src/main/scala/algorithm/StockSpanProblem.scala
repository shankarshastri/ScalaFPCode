/**
  * @author Shankar Shastri
  *         *
  *         Algorithm: Stock Span
  */
package algorithm

import scala.io.StdIn._

object StockSpanProblem {

  def main(args: Array[String]): Unit = {
    println(stockSpan(readLine.split(" ").map(_.toInt).toList))
  }

  /**
    *
    * @param arrList
    * @return List[Int]
    */
  def stockSpan(arrList: List[Int]): List[Int] = {
    arrList.zipWithIndex.map { x => {
      arrList.take(x._2).count(_ < x._1) + 1
    }
    }
  }
}
