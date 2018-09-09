/**
  * @author ShankarShastri
  *         Algorithm: DifferenceArray
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec


object DifferenceArray {
  def diffArr[T](l: List[T])(implicit numeric: Numeric[T]): List[T] = {
    @tailrec
    def diffArrayHelper(l: List[T], accumResult: List[T] = List[T]()):
    List[T] = {
      l match {
        case h :: h1 :: Nil => (numeric.minus(h1,h) :: accumResult).reverse
        case h :: h1 :: tail =>
          diffArrayHelper(h1 :: tail,
            numeric.minus(h1, h) :: accumResult)
      }
    }
    diffArrayHelper(l)
  }
  
  
  def main(args: Array[String]): Unit = {
    val l = List(9,2,6,3,1,5,0,7)
    println(diffArr[Int](l))
  }
}
