/**
  * @author ShankarShastri
  *         Algorithm: ProblemC
  */

package contests.codeforces.cf_496_div3

import scala.io.StdIn._
import scala.annotation.tailrec

object ProblemC {
  def main(args: Array[String]): Unit = {
//    6
//    4 7 1 5 4 9
    readInt
    val l = readLine.split(" ").map(_.toInt).toVector

    val listDiff = for {
      i <- l.indices
      j <- l.indices
      if((l(i) + l(j)).toBinaryString.count(_ == '1') == 1 && i!=j)
    } yield l(i)
    println(l.diff(listDiff.toVector).length)
  }
}
