/**
  * @author ShankarShastri
  *         Algorithm: PrefixSumArr
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec

object PrefixSumArr {
  
  def prefixSumArr[T](l: List[T], startVal: T)(implicit numeric: Numeric[T]): List[T] = {
    @tailrec
    def prefixSumArrHelper(l: List[T], accumResult: List[T] = List[T](startVal)): List[T] = {
      l match {
        case head :: Nil => (numeric.plus(accumResult.head, head) :: accumResult).reverse
        case head :: tail => prefixSumArrHelper(tail, numeric.plus(accumResult.head, head) :: accumResult)
      }
    }
    prefixSumArrHelper(l)
  }
  
  def main(args: Array[String]): Unit = {
    val l = List(9,2,6,3,1,5,0,7)
    val prefixStartVal = -8
    println(prefixSumArr(l, prefixStartVal))
  }
}
