/**
  * @author ShankarShastri
  *         Algorithm: SplitList
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec

object SplitList {
  
  def split[T](l: List[T], k: Int) = {
    require(k > 0)
    @tailrec
    def splitHelper[T](l: List[T],
                       accum: List[T] = List[T](), k: Int): List[T] = {
      k match {
        case 0 =>  l ::: accum.reverse
        case _ =>
          splitHelper(l.tail, l.head :: accum , k - 1)
      }
    }
    splitHelper(l, k = k)
  }
  
  def main(args: Array[String]): Unit = {
    println(split(List(12, 10, 5, 6, 52, 36), 2))
  }
}
