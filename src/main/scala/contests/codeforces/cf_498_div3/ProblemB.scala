/**
  * @author ShankarShastri
  *         Algorithm: ProblemB
  */

package contests.codeforces.cf_498_div3

import scala.io.StdIn._
import scala.annotation.tailrec


object ProblemB {
  def main(args: Array[String]): Unit = {
    val Array(n,k) = readLine.split(" ").map(_.toInt)
    val list = readLine.split(" ").map(_.toInt).toList



    val order = list.sorted.takeRight(k)


    var expected = order.foldLeft((list, 0, List[Int]()))((a,b) => {
      val searchedIndex = a._1.indexOf(b, a._2)
      (a._1, searchedIndex+1, searchedIndex :: a._3)
    })._3.reverse


    if(expected.head != 0) expected = 0 :: expected
    else if(expected.last != list.length -1 ) expected = expected :+ list.length
    val result = expected.sliding(2).toList.map(x => x.tail.head - x.head)

    println(order.sum)
    println(result.mkString(" "))
  }
}
