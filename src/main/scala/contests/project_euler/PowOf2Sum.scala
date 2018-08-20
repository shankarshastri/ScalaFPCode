/**
  * @author ShankarShastri
  *         Algorithm: PowOf2Sum(https://www.hackerrank.com/contests/projecteuler/challenges/euler016)
  */
package contests.project_euler

import scala.io.StdIn._

object PowOf2Sum {
  
  def loopWithReadLine[T](n: Int)(block: String => T): Unit =
    (1 to n).map(_ => {
      println(block(readLine))
    })

  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    loopWithReadLine[Int](t) { i =>
      BigInt(2).pow(i.toInt).toString.map(_.toString.toInt).sum
    }
  }
}
