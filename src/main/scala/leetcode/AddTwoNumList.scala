/**
  * @author ShankarShastri
  *         Algorithm: AddTwoNumList
  */
package leetcode

import scala.annotation.tailrec

object AddTwoNumList {

  /**
    *
    * @param s1
    * @param s2
    * @return
    */
  def addString(s1: String, s2: String): String = {
    @tailrec
    def addStringCompute(s1: String,
                         s2: String,
                         sumString: String = "",
                         carry: Int = 0): String = {
      if (s1.length == 1 && s2.length == 1) {
        val sum = (s1.head.toString.toInt + s2.head.toString.toInt
          + carry.toInt).toString
        sum + sumString
      } else {
        val str = (s1.head.toString.toInt +
          s2.head.toString.toInt + carry.toInt).toString
        val (sumStr, carryStr) = (str.init, str.last)
        if (sumStr == "") {
          addStringCompute(s1.tail, s2.tail, carryStr + sumString, 0)
        } else {
          addStringCompute(s1.tail, s2.tail, carryStr + sumString, sumStr.toInt)
        }
      }
    }

    val maxLength = Math.max(s1.length, s2.length)
    val preparedS1 = ("0" * (maxLength - s1.length) + s1).reverse
    val preparedS2 = ("0" * (maxLength - s2.length) + s2).reverse
    addStringCompute(preparedS1, preparedS2)
  }

  /**
    *
    * @param l1
    * @param l2
    * @return
    */
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val list1 = traverseList(l1).mkString
    val list2 = traverseList(l2).mkString
    val sum = addString(list1, list2).map(_.toString.toInt)
    val constructListNode = new ListNode(0)
    sum.foldLeft(constructListNode)((a, b) => {
      val newNode = new ListNode(b)
      a.next = newNode
      newNode
    })
    constructListNode.next
  }

  /**
    *
    * @param listNode
    * @param x
    * @return
    */
  def addListNode(listNode: ListNode, x: Int): ListNode = {
    val listNodeToReturn = new ListNode(x)
    listNodeToReturn.next = listNode
    listNodeToReturn
  }

  def main(args: Array[String]): Unit = {
    val listNode1 = addListNode(addListNode(new ListNode(2), 4), 3)
    val listNode2 = addListNode(addListNode(new ListNode(5), 6), 4)
    addTwoNumbers(listNode1, listNode2)
  }

  /**
    *
    * @param l1
    * @param list1
    * @return
    */
  @tailrec
  private def traverseList(l1: ListNode,
                           list1: List[Int] = List[Int]()): List[Int] = {
    if (l1 == null) list1
    else {
      traverseList(l1.next, l1.x :: list1)
    }
  }

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
}
