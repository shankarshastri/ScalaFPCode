/**
  * @author ShankarShastri
  *         Algorithm: Generic CountByValues
  */
package algorithm

import scala.annotation.tailrec
import scala.io.StdIn._

object CountByValuesList {
  def main(args: Array[String]): Unit = {
    val x1 = readLine.split(" ").map(_.toInt).toList
    println(countByValuesMap(x1))
  }

  /**
    *
    * @param list
    * @return
    */
  def countByValuesMap[T](list: List[T]): Map[T, Int] = {
    @tailrec
    def countByValuesMapHelper(list: List[T],
                               accumMap: Map[T, Int] = Map[T, Int]()
                                 .withDefaultValue(0)): Map[T, Int] = {
      if (list.length == 1) accumMap.updated(list.head, accumMap(list.head) + 1)
      else {
        list match {
          case head :: tail =>
            countByValuesMapHelper(
              tail,
              accumMap.updated(head, accumMap(head) + 1))
          case _ => accumMap
        }
      }
    }

    countByValuesMapHelper(list)
  }
}
