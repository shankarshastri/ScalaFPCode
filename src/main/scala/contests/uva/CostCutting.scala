/**
  * @author ShankarShastri
  *         Algorithm: CostCutting
  */

package contests.uva

import scala.io.StdIn._
import scala.annotation.tailrec

object CostCutting {
  def main(args: Array[String]): Unit = {
    val n = readLine.toInt
    (1 to n).foreach(i => {
      val l = readLine.split(" ").map(_.toInt).sorted
      println(s"Case ${i}: ${l(1)}")
    })
  }
}
