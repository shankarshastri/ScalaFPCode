/**
  * @author ShankarShastri
  *         Algorithm: Selection Sort
  */
package algorithm

import scala.annotation.tailrec
import scala.io.StdIn._

object SelectionSort {

  def main(args: Array[String]): Unit = {
    println(selectionSort(readLine.split(" ").map(_.toInt).toList))
  }

  /**
    *
    * @param list
    * @return
    */
  def selectionSort(list: List[Int]): List[Int] = {
    @tailrec
    def selectSortHelper(list: List[Int], accumList: List[Int] = List[Int]()): List[Int] = {

      list match {
        case Nil => accumList
        case _ => {
          val min = list.min
          val requiredList = list.filter(_ != min)
          selectSortHelper(requiredList, accumList ::: List.fill(list.length - requiredList.length)(min))
        }
      }
    }

    selectSortHelper(list)
  }
}
