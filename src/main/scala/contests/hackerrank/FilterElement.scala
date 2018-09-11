/**
  * @author ShankarShastri
  *         Algorithm: FilterElement
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object FilterElement {
  
  import scala.io.StdIn._
  import scala.annotation.tailrec
  
  def loop[T](n:BigInt)(block: => T) = (BigInt(1) to n).foreach(_ => block)
  
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
  
  def orderByIndex[T](l: List[T], filteredList: List[T]): List[T] =
    l.distinct.filter(e => filteredList.exists(_ == e))
  
  def main(args: Array[String]) {
    val t = BigInt(readLine)
    loop(t) {
      val Array(_, count) = readLine().split(" ").map(_.toInt)
      val l = readLine().split(" ").map(_.toInt).toList
      val result = orderByIndex(l, filterByCount(l, count))
      if(result.isEmpty) println("-1")
      else println(result.mkString(" "))
    }
  }
}