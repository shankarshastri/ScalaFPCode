/**
  * @author ShankarShastri
  *         Algorithm: NthMinimiumElement
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec
//TODO QuickSelectionAlgo
object SecondMinimiumElement {
  def nthMinimiumElement[@specialized(Int, Double) T](l: List[T], n: Int, cmp: (T, T) => Boolean): T =
    l.sorted(Ordering fromLessThan[T](cmp)).take(n).last
  
  
  def main(args: Array[String]): Unit = {
    nthMinimiumElement(List[Short](3,2,1), 2, (x: Short, y: Short) => x < y)
  }
}
