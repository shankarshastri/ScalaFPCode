/**
  * @author ShankarShastri
  *         Algorithm: StringDiff (https://leetcode.com/contest/weekly-contest-97/problems/uncommon-words-from-two-sentences/)
  */

package leetcode

import scala.io.StdIn._
import scala.annotation.tailrec

object codeOpsStringDiff {
  def readLineToList(str: String = readLine) = str.split(" ").map(_.toInt).toList
  
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



object StringDiff {
  def uncommonFromSentences(A: String, B: String): Array[String] = {
    val xSplitArray = A.split(" ").sorted
    val ySplitArray = B.split(" ").sorted
    
    xSplitArray.diff(ySplitArray).filter(el => {
      xSplitArray.indexOf(el) == xSplitArray.lastIndexOf(el)
    }) ++ ySplitArray.diff(xSplitArray).filter(el => {
      ySplitArray.indexOf(el) == ySplitArray.lastIndexOf(el)
    })
  }
  
  def main(args: Array[String]): Unit = {
    val appleSentence = "op vu kux dn jsenj hbdez hbdez nbenh z op dxmqd op"
    val bananaSentence = "kux wnx wnx wbi jsenj nlgfn vu f vu fvxas dn op tb"
    uncommonFromSentences(appleSentence, bananaSentence)
  }
}
