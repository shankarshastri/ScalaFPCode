//import scala.collection.JavaConverters._
//
//// you can write to stdout for debugging purposes, e.g.
//// println("this is a debug message")
//
//object Solution {
//  def removeElement(list: List[Int], index: Int): List[Int] = {
//    list.patch(index, Nil, 1)
//  }
//
//  def checkSingleSwap(list: List[Int]): Boolean = {
//    val listWithIndex = list.zipWithIndex
//    val reversedListWithIndex = listWithIndex.reverse
//    var leftTupleList: List[(Int, Int)] = List[(Int, Int)]()
//    var rightTupleList: List[(Int, Int)] = List[(Int, Int)]()
//    // Takes O(n)
//    for ((f, s) <- listWithIndex zip listWithIndex.drop(1)) {
//      if (f._1 >= s._1) leftTupleList = leftTupleList :+ f
//    }
//    // Takes O(n)
//    for ((f, s) <- reversedListWithIndex zip reversedListWithIndex.drop(1)) {
//      if (f._1 <= s._1) rightTupleList = rightTupleList :+ f
//    }
//
//    if(leftTupleList.isEmpty || rightTupleList.isEmpty)
//      return false
//
//    val leftTuple = leftTupleList.head
//    val rightTuple = rightTupleList.last
//
//    val listAfterSwap =
//      list
//        .updated(leftTuple._2, rightTuple._1)
//        .updated(rightTuple._2, leftTuple._1)
//    val listRemoveLeftElement = removeElement(
//      removeElement(list, leftTuple._2),
//      rightTuple._2 + 1) ::: List(leftTuple._1) ::: List(list.last)
//    val sortedList = list.sortWith(_ < _)
//    ((listAfterSwap == sortedList) || (listRemoveLeftElement == sortedList))
//  }
//  def solution(a: Array[Int]): Boolean = {
//    // write your code in Scala 2.12
//    checkSingleSwap(a.toList)
//  }
//}
