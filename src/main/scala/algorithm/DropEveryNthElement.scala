/**
  * @author ShankarShastri
  *         Algorithm: Drop Nth Element
  */

package algorithm

import scala.annotation.tailrec
import scala.io.StdIn._

object DropEveryNthElement {
  def main(args: Array[String]): Unit = {
    val nth = readInt
    println(dropEveryNthElement(nth, readLine.split(" ").map(_.toInt).toList))
  }

  /**
    *
    * @param nth
    * @param list
    * @tparam T
    * @return
    */
  def dropEveryNthElement[T](nth: Int, list: List[T]): List[T] = {
    @tailrec
    def dropEveryNthElementHelper(n: Int = 0, accum: List[T] = List[T]()): List[T] = {
      if (n == list.length) accum
      else {
        if ((n + 1) % nth != 0) dropEveryNthElementHelper(n + 1, accum :+ list(n))
        else dropEveryNthElementHelper(n + 1, accum)
      }
    }

    dropEveryNthElementHelper()
  }
}
