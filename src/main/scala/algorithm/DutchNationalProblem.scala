/**
  * @author Shankar Shastri
  *         *
  *         Algorithm: DNF Problem
  */
package algorithm

import scala.io.StdIn._

object DutchNationalProblem {

  //Sort 0,1,2 => Dutch National Flag Algorithm ThreePartition Algorithm
  def main(args: Array[String]): Unit = {
    println(sort012(readLine.split(" ").map(_.toInt).toList))
  }

  // DNF Algorithm is using low, mid, high where in for case 0 will swap low and increment low
  // for case 1 increment mid for case 2 decrement high and swap digits
  def sort012(arrList: List[Int]): List[Int] =
    createNList(arrList, 0) ++ createNList(arrList, 1) ++ createNList(arrList, 2)

  /**
    *
    * @param arrList List[Int]
    * @param n       Int
    * @return List[Int]
    */
  def createNList(arrList: List[Int], n: Int): List[Int] = List.fill(arrList.count(_ == n))(n)
}
