/**
  * @author ShankarShastri
  *         Algorithm: ProblemA
  */

package contests.codeforces.cf_498_div3

import scala.io.StdIn._
import scala.annotation.tailrec

object ProblemA {
  def main(args: Array[String]): Unit = {
    val _ = readInt
    val arrList = readLine().split(" ").map(_.toInt).toList
    val res = arrList.map(x => {
      if(x%2 ==0) x-1
      else x
    })
    println(res.mkString(" "))
  }
}
