/**
  * @author ShankarShastri
  *         Algorithm: TaumAndBirthday
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec


import java.io._

object TaumAndBirthday {
  
  // Complete the taumBday function below.
  def taumBday(b: BigInt, w: BigInt, bc: BigInt, wc: BigInt, z: BigInt): BigInt = {
    val a = (b+w) * bc + w * z
    val a1 = (b+w) * wc + b * z
    val a2 = b*bc + w * wc
    List(a,a1,a2).min
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(System.out)
    val t = stdin.readLine.trim.toInt
    for (tItr <- 1 to t) {
      val bw = stdin.readLine.split(" ")
      val b = bw(0).trim.toInt
      val w = bw(1).trim.toInt
      val bcWcz = stdin.readLine.split(" ")
      val bc = bcWcz(0).trim.toInt
      val wc = bcWcz(1).trim.toInt
      val z = bcWcz(2).trim.toInt
      val result = taumBday(b, w, bc, wc, z)
      printWriter.println(result)
    }
    printWriter.close()
  }
}
