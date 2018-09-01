/**
  * @author ShankarShastri
  *         Algorithm: MES
  */

package contests.codeforces.cf_1029

import scala.io.StdIn._
import scala.annotation.tailrec

object MES {
  def readLineToList(str: String = readLine) = str
    .replaceAll("\\s+$", "")
    .split(" ")
    .map(_.trim.toInt)
    .toList
  
  def main(args: Array[String]): Unit = {
    val Array(_, k) = readLineToList().toArray
    val s = readLine()
    val res = (1 until k).foldLeft(s)((a, _) => {
      if(a.last != s.head || s.length == 1) a + s else a.init + s
    })
    println(res)
  }
}
