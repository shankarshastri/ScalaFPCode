/**
  * @author ShankarShastri
  *         Algorithm: ProblemB
  */

package contests.codeforces.cf_496_div3

import scala.io.StdIn._

object codeOps {
  def commonString(x1: List[Char], x2: List[Char], common: List[Char] = List[Char]()): List[Char] = {
    if(x1.length == 0 || x2.length ==0) common
    else {
      if(x1.head == x2.head) commonString(x1.tail, x2.tail, x1.head :: common)
      else commonString(x1.tail, x2.tail, common)
    }
  }
}

object ProblemB {
  import codeOps._
  def main(args: Array[String]): Unit = {
    val x1 = readLine()
    val x2 = readLine()
    if(x1 == x2) println(x1.length * 2)
    else {
      val len = commonString(x1.reverse.toCharArray.toList, x2.reverse.toCharArray.toList).length
      println((x1.length - len) + (x2.length - len))
    }
  }
}
