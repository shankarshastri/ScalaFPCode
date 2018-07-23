/**
  * @author ShankarShastri
  *         Algorithm: LeafSeq (https://leetcode.com/contest/weekly-contest-94/problems/leaf-similar-trees/)
  */

package leetcode

import scala.io.StdIn._
import scala.annotation.tailrec

object LeafSeq {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null

    override def toString: String = {
      this.value.toString
    }
  }
  def getLeafSequenceInString(t: TreeNode): String = {
    if(t.left == null && t.right == null) {
      t.value.toString
    } else if(t.right == null) {
      getLeafSequenceInString(t.left)
    } else if(t.left == null) {
      getLeafSequenceInString(t.right)
    } else {
      getLeafSequenceInString(t.left) + getLeafSequenceInString(t.right)
    }
  }

  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    getLeafSequenceInString(root1) == getLeafSequenceInString(root2)
  }
  def main(args: Array[String]): Unit = {
    val x1 = new TreeNode(10)
    x1.right = new TreeNode(11)
    x1.left = new TreeNode(12)
    val x2 = new TreeNode(10)
    x2.right = new TreeNode(110)
    x2.right.right = new TreeNode(11)
    x2.left = new TreeNode(12)
    leafSimilar(x1, x2)
  }
}
