/**
  * @author ShankarShastri
  *         Algorithm: ProjectionArea
  *         (https://leetcode.com/contest/weekly-contest-96/problems/projection-area-of-3d-shapes/)
  *         https://s3-lc-upload.s3.amazonaws.com/uploads/2018/08/02/shadow.png
  */

package leetcode

import scala.io.StdIn._
import scala.annotation.tailrec

object ProjectionArea {
  def pickNthElement(l: List[Int], n: Int): List[Int] = {
    val stepByN = if (n <=1) n+1 else n
    val res = for {
      e <- n-1 until l.length by stepByN
    } yield l(e)
    res.toList
  }
  
  def projectionArea(grid: Array[Array[Int]]): Int = {
    val xArea = grid.flatten.filter(_ > 0).length
    val lenOfIndArray = grid.head.length
    val yArea = (1 to lenOfIndArray).map(ele => pickNthElement(grid.flatten.toList, ele)).map(_.max).sum
    val zArea = grid.map(_.max).sum
    xArea + yArea + zArea
  }
  
  def main(args: Array[String]): Unit = {
    val projectOfAreas = Array[Array[Int]](Array(2,2,2), Array(2,1,2), Array(2,2,2))
   projectionArea(projectOfAreas)
  }
}
