///**
//  * @author ShankarShastri
//  *         Algorithm: RotateList
//  */
//
//package leetcode
//
//import scala.io.StdIn._
//import scala.annotation.tailrec
//
//object codeOps {
//  def readLineToList(str: String = readLine) = str.split(" ").map(_.toInt).toList
//
//  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
//
//  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
//
//  def listOps[T](list: List[T])(baseCaseOp: List[T] => Boolean,
//                                genericCaseOp: (List[T], List[T]) => (List[T], List[T]),
//                                lastCaseOp: (T, List[T]) => List[T]): List[T] = {
//    @tailrec
//    def listOpsHelper(list: List[T],
//                      accumList: List[T] = List[T]()): List[T] = {
//      if (baseCaseOp(list)) {
//        lastCaseOp(list.head, accumList)
//      }
//      else {
//        val res = genericCaseOp(list, accumList)
//        listOpsHelper(res._1, res._2)
//      }
//    }
//
//    listOpsHelper(list)
//  }
//
//  def streamOps[T](list: Stream[T])(baseCaseOp: Stream[T] => Boolean,
//                                    genericCaseOp: (Stream[T], Stream[T]) => (Stream[T], Stream[T]),
//                                    lastCaseOp: (T, Stream[T]) => Stream[T]): Stream[T] = {
//    @tailrec
//    def streamOpsHelper(list: Stream[T],
//                        accumList: Stream[T] = Stream[T]()): Stream[T] = {
//      if (baseCaseOp(list)) {
//        lastCaseOp(list.head, accumList)
//      }
//      else {
//        val res = genericCaseOp(list, accumList)
//        streamOpsHelper(res._1, res._2)
//      }
//    }
//
//    streamOpsHelper(list)
//  }
//}
//
//
//class ListNode(var _x: Int = 0) {
//  var next: ListNode = null
//  var x: Int = _x
//}
//
//object SolutionRotate {
//
//  import scala.annotation.tailrec
//  @tailrec
//  def numberOfElements(listNode: ListNode, count: Int = 0): Int = {
//    if (listNode.next != null) {
//      numberOfElements(listNode.next, count+1)
//    } else {
//      count+1
//    }
//  }
//
//  @tailrec
//  def rotateOnce(headNext: ListNode, data: Int, firstNode: ListNode): ListNode = {
//    if(headNext == null) {
//      firstNode.x = data
//      firstNode
//    }
//    else {
//      val tmp = headNext.x
//      headNext.x = data
//      rotateOnce(headNext.next, tmp, firstNode)
//    }
//  }
//
//  def rotateRight(head: ListNode, k: Int): ListNode = {
//    val count = numberOfElements(head)
//    if(head!=null && head.next != null)
//      (1 to k%count).foldLeft(head)((a,_) => rotateOnce(a.next, a.x, a))
//    else head
//  }
//}
//object RotateList {
//  def main(args: Array[String]): Unit = {
//    def listNodeGenerator() = {
//      val listNode = new ListNode(0)
//      (1 to 5).foldLeft(listNode)((a,b) => {
//        a.next = new ListNode(b)
//        a.next
//      })
//      listNode
//    }
//    SolutionRotate.rotateRight(listNodeGenerator(), 10)
//  }
//}
