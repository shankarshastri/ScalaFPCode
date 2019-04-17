/**
  * @author ShankarShastri
  *         Algorithm: RestoringThreeNumbers
  */

package contests.codeforces.cf_1154

import scala.io.StdIn._
import scala.annotation.tailrec

object RestoringThreeNumbers {
  def main(args: Array[String]): Unit = {
    val l = readLine.split(" ").map(_.toInt)
    val abc = l.max
    println(l.filter(abc - _ != 0).map(abc - _).mkString(" "))
  }
}
