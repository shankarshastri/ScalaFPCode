/**
  * @author Shankar Shastri
  *         *
  *         Algorithm: TrappedWater
  */
package algorithm

import scala.annotation.tailrec
import scala.io.StdIn._

object TrappedWater {
  def main(args: Array[String]): Unit = {
    val numOfTestCases = readInt()
    (1 to numOfTestCases).foreach {
      _ => {
        readInt()
        val elements = readLine().split(" ").map(_.toInt).toList
        println(compute(elements))
      }
    }
  }

  /**
    *
    * @param list
    * @return Int
    */
  def compute(list: List[Int]): Int = {
    @tailrec
    def computeHelper(list: List[Int], initialElement: Int, sum: Int = 0): Int = {
      if (list.length == 1) sum
      else {
        val computedVal = initialElement - list.head
        if (computedVal > 0)
          computeHelper(list.tail, initialElement, sum + computedVal)
        else sum
      }
    }

    computeHelper(list.tail, list.head)
  }
}
