/**
  * @author ShankarShastri
  *         Algorithm: CF_485_DIV_2_1 (http://codeforces.com/contest/987/problem/A)
  */

package contests.codeforces.cf_485_div2

import scala.io.StdIn._

object CF_485_DIV_2_1 {

  //  the Power Gem of purple color,
  //  the Time Gem of green color,
  //  the Space Gem of blue color,
  //  the Soul Gem of orange color,
  //  the Reality Gem of red color,
  //  the Mind Gem of yellow color.


  def main(args: Array[String]): Unit = {
    val n = readInt
    val thanosMap = Map[String, String](("purple", "Power"), ("green", "Time"), ("blue", "Space"),
      ("orange", "Soul"), ("red", "Reality"), ("yellow", "Mind"))
    if (n == 0) {
      println(thanosMap.size)
      thanosMap.values.map(println(_))
    } else {
      val mapResult = (0 until n).foldLeft(thanosMap)((a, b) => {
        val k = readLine
        a - k
      })
      println(mapResult.size)
      mapResult.values.map(println(_))
    }
  }
}
