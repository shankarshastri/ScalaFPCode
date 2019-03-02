/**
  * @author ShankarShastri
  *         Algorithm: ToyBox
  */

package contests.hackerearth

import scala.io.StdIn._
import scala.collection.mutable

object ToyBox {
  def main(args: Array[String]): Unit = {
    val Array(n, m) = readLine.split(" ").map(_.toInt)
    val it = (1 to n).foldLeft(new mutable.OpenHashMap[Int, Int](m).withDefaultValue(0))((a, _) => {
      val Array(cost, box) = readLine.split(" ").map(_.toInt)
      a.updated(box, Math.max(cost, a.getOrElse(box, 0)))
    })
    println(it.values.sum)
  }
}