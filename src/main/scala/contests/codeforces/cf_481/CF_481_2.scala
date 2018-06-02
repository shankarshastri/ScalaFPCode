package contests.codeforces.cf_481

import scala.annotation.tailrec

object CF_481_2 extends App {
  val n = scala.io.StdIn.readLine.toInt
  val fileName = scala.io.StdIn.readLine

  @tailrec
  def subStringExtractor(string: String, subString: String, count: Int = 0): Int = {
    if (string.indexOf(subString) == -1) count
    else {
      val createdString = string.substring(string.indexOf(subString) + 1)
      subStringExtractor(createdString, subString, count + 1)
    }
  }

  println(subStringExtractor(fileName, "xxx"))

}
