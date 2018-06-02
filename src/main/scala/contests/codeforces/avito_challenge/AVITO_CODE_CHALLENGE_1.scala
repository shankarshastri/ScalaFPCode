package contests.codeforces.avito_challenge

import scala.io.StdIn._

object AVITO_CODE_CHALLENGE_1 {
  def main(args: Array[String]): Unit = {
    val str = readLine
    if (str != str.reverse) println(str.length)
    else if (str.distinct.length == 1) println("0")
    else {
      println(str.zipWithIndex.map(x => str.substring(x._2)).filter(x => x.reverse != x).map(_.length).max)
    }
  }
}
