/**
  * @author ShankarShastri
  *         Algorithm: MiddleOfLinkedList (https://leetcode.com/problems/middle-of-the-linked-list/description/)
  */

package leetcode
import scala.io.StdIn._
import scala.annotation.tailrec

object MiddleOfLinkedList {
  import scala.annotation.tailrec

  object Solution {
    @tailrec
    def traverseList(l1: ListNode,
                     list1: List[Int] = List[Int]()): List[Int] = {
      if (l1 == null) list1
      else {
        traverseList(l1.next, l1.x :: list1)
      }
    }
    
    def getMiddleElement(l: ListNode, count: Int): ListNode ={
      if(l == null || count == 0) l
      else getMiddleElement(l.next, count - 1)
    }
    
    def middleNode(head: ListNode): ListNode = {
      val len = traverseList(head).length
      getMiddleElement(head,len/2)
    }
    
    class ListNode(var _x: Int = 0) {
      var next: ListNode = null
      var x: Int = _x
    }
  }
  import Solution._
  def main(args: Array[String]): Unit = {
    middleNode(new ListNode(1))
  }
}
