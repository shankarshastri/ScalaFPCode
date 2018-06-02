/**
  * @author ShankarShastri
  *         Algorithm: TwoSum
  */

package leetcode

object TwoSum {
  def main(args: Array[String]): Unit = {
    twoSum(Array(1, 2, 3), 3)
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var flag = true
    val vec = for {
      i <- 0 until nums.length
      j <- 0 until nums.length
      if (nums(i) + nums(j) == target) && (i != j) && (flag == true)
    } yield {
      flag = false
      (i, j)
    }
    Array(vec.head._1, vec.head._2)
  }
}
