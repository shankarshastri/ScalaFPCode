/**
  * @author ShankarShastri
  *         Algorithm: ReorderedPower
  */

package leetcode

import scala.io.StdIn._
import scala.annotation.tailrec

object codeOps {
  def readLineToList(str: String = readLine) = str.split(" ").map(_.toInt).toList

  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)

  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList

  def listOps[T](list: List[T])(baseCaseOp: List[T] => Boolean,
                                genericCaseOp: (List[T], List[T]) => (List[T], List[T]),
                                lastCaseOp: (T, List[T]) => List[T]): List[T] = {
    @tailrec
    def listOpsHelper(list: List[T],
                      accumList: List[T] = List[T]()): List[T] = {
      if (baseCaseOp(list)) {
        lastCaseOp(list.head, accumList)
      }
      else {
        val res = genericCaseOp(list, accumList)
        listOpsHelper(res._1, res._2)
      }
    }

    listOpsHelper(list)
  }

  def streamOps[T](list: Stream[T])(baseCaseOp: Stream[T] => Boolean,
                                    genericCaseOp: (Stream[T], Stream[T]) => (Stream[T], Stream[T]),
                                    lastCaseOp: (T, Stream[T]) => Stream[T]): Stream[T] = {
    @tailrec
    def streamOpsHelper(list: Stream[T],
                        accumList: Stream[T] = Stream[T]()): Stream[T] = {
      if (baseCaseOp(list)) {
        lastCaseOp(list.head, accumList)
      }
      else {
        val res = genericCaseOp(list, accumList)
        streamOpsHelper(res._1, res._2)
      }
    }

    streamOpsHelper(list)
  }
}

object ReorderedPower {
  def isPowerOfTwo(x: Int): Boolean = {
    (x != 0) && ((x & x - 1) == 0)
  }
  def reorderedPowerOf2(N: Int): Boolean = {
    if(isPowerOfTwo(N)) true else {
      N.toString
        .permutations.toStream
        .filter(x => !x.startsWith("0") && isPowerOfTwo(x.toInt))
        .nonEmpty
    }
  }
  def main(args: Array[String]): Unit = {
    reorderedPowerOf2(46)
  }
}