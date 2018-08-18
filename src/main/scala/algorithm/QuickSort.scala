/**
  * @author ShankarShastri
  *         Algorithm: QuickSort
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec



object QuickSort {
  
  def quickSort(list:List[Int]): List[Int] = {
    if(list.length < 2) list
    else {
      val pivotElement = list(list.length/2)
      quickSort(list.filter(_ < pivotElement))  ::: list.filter(_ == pivotElement) ::: quickSort(list.filter(_ > pivotElement))
    }
  }
  
  def main(args: Array[String]): Unit = {
   quickSort(List(1,9,9,1))
  }
}
