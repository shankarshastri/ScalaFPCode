/**
  * @author ShankarShastri
  *         Algorithm: BuildingPalindrome
  */
package contests.kickstart_2019

import scala.io.StdIn._

object BuildingPalindrome {

  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    (1 to t).foreach { n =>
      {
        val Array(_, q) = readLine.split(" ").map(_.toInt)
        val s = readLine
        val countPrefixMap = s.scanLeft(Map[Char, Int]())((a,b) => {
          a.updated(b, a.getOrElse(b, 0) + 1)
        })
        val result = (1 to q).foldLeft(0) { (a, _) =>
          {
            val Array(l, r) = readLine.split(" ").map(_.toInt)
            val countPrefixLToR = countPrefixMap(r).map(e => e._2 - countPrefixMap(l-1).getOrElse(e._1, 0))
            val res = countPrefixLToR.count(e => (e % 2) == 1)
            if(res <= 1) {
              a + 1
            } else a
          }
        }
        println(s"Case #${n}: ${result}")
      }
    }
  }
}
