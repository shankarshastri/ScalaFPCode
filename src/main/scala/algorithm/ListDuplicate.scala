/**
  * @author ShankarShastri
  *         Algorithm: Duplicate List
  */

package algorithm

import scala.annotation.tailrec
import scala.io.StdIn._

object ListDuplicate {
  def main(args: Array[String]): Unit = {
    val n = readInt
    val list = readLine.split(" ").map(_.toInt).toList
    println(duplicateListN(n, list))
  }

  /**
    *
    * @param n
    * @param list
    * @tparam T
    * @return
    */
  def duplicateListN[T](n: Int, list: List[T]): List[T] = {
    @tailrec
    def duplicateListNHelper(n: Int, accum: List[T]): List[T] = {
      if (n == 0) accum
      else duplicateListNHelper(n - 1, accum ::: list)
    }

    duplicateListNHelper(n, List[T]())
  }
}
