/**
  * @author ShankarShastri
  *         Algorithm: FilterByCount
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec

object FilterByCount {
  
  def filterByCount[T](l: List[T], count: BigInt): List[T] = {
    @tailrec
    def filterByCountHelper[T](l: List[T], accumList: Map[T, BigInt]): List[T] = {
      l match {
        case Nil => List[T]()
        case head :: Nil =>
          accumList
            .updated(head, accumList.getOrElse(head, BigInt(0)) + 1)
            .filter(e => e._2 >= count)
            .keys
            .toList
        case head :: tail =>
          filterByCountHelper(tail, accumList
            .updated(head, accumList.getOrElse(head, BigInt(0)) + 1))
      }
    }
    filterByCountHelper(l, Map[T, BigInt]().withDefaultValue(0))
  }
  
  def main(args: Array[String]): Unit = {
    val l = List(4, 5, 2, 5, 4, 3, 1, 3, 4)
    println(filterByCount(l, 2))
  }
}
