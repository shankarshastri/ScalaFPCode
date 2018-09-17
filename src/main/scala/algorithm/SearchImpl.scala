/**
  * @author ShankarShastri
  *         Algorithm: Search Implementations
  */
package algorithm

import scala.annotation.tailrec

object SearchImpl {
  /**
    *
    * @param list
    * @param element
    * @tparam T
    * @return
    */
  @tailrec
  def linearSearch[T](list: List[T], element: T): Boolean = {
    list match {
      case head :: _ if head == element => true
      case _ :: Nil => false
      case _ :: tail => linearSearch(tail, element)
    }
  }

  /**
    *
    * @param list
    * @param element
    * @tparam T
    * @return
    */
  def binarySearch[T <: Int](list: List[T], element: T): Boolean = {

    @tailrec
    def binarySearchHelper(list: List[T], low: Int = 0, high: Int = list.length - 1): Boolean = {
      val mid = (list.length / 2)
      val lisMid = list(mid)
      if (element == lisMid) true
      else if (element > lisMid) binarySearchHelper(list, mid, high)
      else binarySearchHelper(list, low, mid)
    }

    binarySearchHelper(list.sortWith(_ < _))
  }
}