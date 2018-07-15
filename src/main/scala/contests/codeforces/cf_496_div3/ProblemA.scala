/**
  * @author ShankarShastri
  *         Algorithm: ProblemA
  */

package contests.codeforces.cf_496_div3

import scala.io.StdIn._
import scala.annotation.tailrec



object ProblemA {

  def getAllIndicesOfElement[T](element: T, l: List[T]): List[Int] = {
    @tailrec
    def getAllIndicesHelper(l: List[T], accumList: List[Int] = List[Int](), index: Int=0): List[Int] = {
      if(l.length == 0) {
        (index :: accumList).reverse
      }  else {
        l match {
          case head :: tail if head == element => getAllIndicesHelper(tail, index :: accumList, index+1)
          case _ :: tail => getAllIndicesHelper(tail, accumList, index+1)
        }
      }
    }
    getAllIndicesHelper(l)
  }

  def tanyaStairwayStr(list: List[Int]): String = {
    getAllIndicesOfElement(1, list).sliding(2).toList.map(_.reduce((a,b) => b - a)).mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    val _ = readInt
    val arr = readLine().split(" ").map(_.toInt).toList
    println(arr.count(_ == 1))
    println(tanyaStairwayStr(arr))
  }
}
