/**
  * @author ShankarShastri
  *         Algorithm: Rotate List
  */
package algorithm

import scala.io.StdIn._

object RotateList {

  def main(args: Array[String]): Unit = {
    println(rotateList(readLine.split(" ").map(_.toInt).toList, 0, 1))
  }

  def rotateList[T](list: List[T], start: Int, end: Int): List[T] = {
    list.slice(0, start) ::: list.slice(start, end + 1).reverse ::: list.slice(end + 1, list.length)
  }
}
