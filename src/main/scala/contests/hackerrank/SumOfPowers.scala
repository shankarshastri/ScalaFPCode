/**
  * @author ShankarShastri
  *         Algorithm: SumOfPowers (https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers/problem)
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

object codeOpsSumOfPowers {
  def readLineToList(str: String = readLine) = str.split(" ").map(_.toInt).toList
  
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
  
  def rotateList[T](ls: List[T], rotateCount: Int): List[T] = {
    (1 to rotateCount).foldLeft(ls)((a, _) => {
      val (l1, l2) = a.splitAt(a.length - 1)
      l2 ::: l1
    })
  }
}

object SumOfPowers {
  
  def main(args: Array[String]) {
    println(numberOfWays(readInt(), readInt()))
  }
  
  def numberOfWays(X: Int, N: Int): Int = {
    // Compute the answer in this function over here
    // It is fine to define new functions as and where required
    val maxNum = Math.sqrt(X).toInt
    val powList = (1 to maxNum).filter(Math.pow(_, N).toInt <= X)
      .map(Math.pow(_, N).toInt).toList
    subsetSum(powList, powList.length, X)
  }
  
  def subsetSum(l: List[Int], n: Int, sum: Int): Int = {
    if (sum == 0) 1
    else if (sum != 0 && n == 0) 0
    else subsetSum(l, n - 1, sum) + subsetSum(l, n - 1, sum - l(n - 1))
  }
}
