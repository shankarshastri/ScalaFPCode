/**
  * @author ShankarShastri
  *         Algorithm: ProblemB(http://codeforces.com/contest/999/problem/B)
  */

package contests.codeforces.cf_490_div3

import scala.io.StdIn._
import scala.annotation.tailrec

object ProblemB {
  def readLineToList = readLine.split(" ").map(_.toInt).toList

  def main(args: Array[String]): Unit = {
      val max = readLine.toInt
      val encryptedStr = readLine
      val divisors = (1 to max).filter(max % _ == 0)

      val result = divisors.foldLeft(encryptedStr)((a,b) => {
        a.substring(0, b).reverse + a.splitAt(b)._2
      })
      println(result)
  }
}


//
//val max = 10
//val listEke = (1 to max).filter(max % _ == 0).reverse
//val listDke = listEke.reverse
//val str = "codeforces"
//
//val res = listEke.foldLeft(str)((a,b) => {
//a.substring(0, b).reverse + a.splitAt(b)._2
//})
//
//
//
//
//
//listDke.foldLeft(res)((a,b) => {
//a.substring(0, b).reverse + a.splitAt(b)._2
//})


