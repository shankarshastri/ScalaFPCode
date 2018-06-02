/**
  * @author ShankarShastri
  *         Algorithm: Generic List Differences
  */
package algorithm

import scala.annotation.tailrec
import scala.io.StdIn._

object ListDifferences {

  def main(args: Array[String]): Unit = {
    val x1 = readLine.split(" ").map(_.toInt).toList
    val x2 = readLine.split(" ").map(_.toInt).toList
    println(diffLists(x1, x2))
  }

  /**
    *
    * @param x1 List[Int]
    * @param x2 List[Int]
    * @return List[Int]
    */
  def diffLists[T](x1: List[T], x2: List[T]): List[T] = {
    x1.foldLeft(x2)((a, b) => {
      removeElement(a, b)
    }) ::: x2.foldLeft(x1)((a, b) => {
      removeElement(a, b)
    })
  }

  /**
    *
    * @param list
    * @param ele
    * @return
    */
  def removeElement[T](list: List[T], ele: T): List[T] = {
    @tailrec
    def removeElementHelper(list: List[T],
                            accumList: List[T] = List[T]()): List[T] = {
      if (list.length == 1) {
        if (list.head == ele) accumList.reverse
        else accumList.reverse ::: list
      } else {
        list match {
          case head :: tail if (head != ele) =>
            removeElementHelper(tail, head :: accumList)
          case head :: tail if (head == ele) => (accumList.reverse ::: tail)
          case _ => accumList
        }
      }
    }

    removeElementHelper(list)
  }
}
