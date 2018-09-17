/**
  * @author ShankarShastri
  *         Algorithm: SortArrayByParty
  */

package leetcode

import scala.io.StdIn._
import scala.annotation.tailrec

object codeOpsSortArrayByParty {
  def readLineToList(str: String = readLine) = str.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
  
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
  
  def rotateList[T](ls: List[T], rotateCount: Int): List[T] = {
    (1 to rotateCount).foldLeft(ls)((a, _) => {
      val (l1, l2) = a.splitAt(a.length - 1)
      l2 ::: l1
    })
  }
  
  
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

object SortArrayByParty {
  def main(args: Array[String]): Unit = {
    
  }
}
