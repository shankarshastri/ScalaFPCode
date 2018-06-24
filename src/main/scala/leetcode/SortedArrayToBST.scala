/**
  * @author ShankarShastri
  *         Algorithm: SortedArrayToBST (https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
  */

package leetcode

import scala.io.StdIn._
import scala.annotation.tailrec

object SortedArrayToBST {
  /**
    * Definition for a binary tree node.
    * class TreeNode(var _value: Int) {
    *   var value: Int = _value
    *   var left: TreeNode = null
    *   var right: TreeNode = null
    * }
    */

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null

    override def toString: String = {
      this.value.toString
    }
  }

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    if(nums.length == 0) null else {
      val midIndex = nums.length/2
      val treeNode = new TreeNode(nums(midIndex))
      treeNode.left = sortedArrayToBST(nums.slice(0, midIndex))
      treeNode.right = sortedArrayToBST(nums.slice(midIndex+1, nums.length))
      treeNode
    }
  }
  def main(args: Array[String]): Unit = {
      sortedArrayToBST(readLine().split(" ").map(_.toInt))
  }
}
