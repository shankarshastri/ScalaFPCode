/**
  * @author ShankarShastri
  *         Algorithm: SumLists
  */

package contests.ctci

import scala.io.StdIn._
import scala.annotation.tailrec

object SumLists {
  //TODO list size differs
  def sumLists(a: List[Int],  b: List[Int]): List[Int] = {
    val res = a.zip(b).foldLeft((List.empty[Int], 0))((a,b) => {
      if(b._1 + b._2 + a._2 > 10) ((b._1 + b._2 + a._2) % 10 :: a._1,
        (b._1 + b._2 + a._2) / 10)
      else  (b._1 + b._2 + a._2 :: a._1, 0)
    })
  
    if(res._2 == 0) res._1.reverse else res._1.reverse :+ res._2
  }
  def main(args: Array[String]): Unit = {
    val a = List(7,1,6)
    val b = List(5,9,2)
    sumLists(a, b)
  }
}
