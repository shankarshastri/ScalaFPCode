/**
  * @author ShankarShastri
  *         Algorithm: IncreasingContinuousTriplet
  */

package leetcode

import scala.io.StdIn._

object IncreasingContinuousTriplet {

  def main(args: Array[String]): Unit = {
    increasingTripletSeq(readLine.split(" ").map(_.toInt).toList)
  }

  def increasingTripletSeq(list: List[Int]) = {
    if (list.length <= 2) false else {
      val res = for {
        i <- 1 until list.length - 1
      } yield {
        if ((list(i - 1) < list(i)) && (list(i) < list(i + 1))) {
          true
        }
        else false
      }
      res.reduce(_ || _)
    }
  }
}
