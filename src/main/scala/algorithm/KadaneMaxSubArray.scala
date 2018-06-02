/**
  * @author Shankar Shastri
  *         *
  *         Algorithm: Kadane's Algorithm
  */
package algorithm

import scala.io.StdIn._

object KadaneMaxSubArray {

  def main(args: Array[String]): Unit = {
    println(maxSubArray(readLine.split(" ").map(_.toInt).toList))
  }

  /**
    *
    * @param arrList List Of Int
    * @return Int Max SubArray
    */
  def maxSubArray(arrList: List[Int]): Int = {
    var maxEndingHere: Int = 0
    var maxSoFar: Int = 0
    arrList.foreach { x => {
      maxEndingHere += x
      if (maxEndingHere < 0) maxEndingHere = 0
      if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere
    }
    }
    maxSoFar
  }
}
