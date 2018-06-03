/**
  * @author ShankarShastri
  *         Algorithm: TripletSum
  */

package algorithm

object TripletSum {

  def main(args: Array[String]): Unit = {
    val x = 20
    val list = List(1, 4, 45, 6, 10, -8)
    tripletSum(list, x)
  }

  def tripletSum(list: List[Int], sum: Int) = {
    val res = for {
      i <- list.indices
    } yield {
      for {
        j <- i + 1 until list.length - 1
        k <- list.length - 1 to i + 1 by -1
        if (sum == list(i) + list(j) + list(k)) && (j != k)
      } yield {
        (i, j, k)
      }
    }
    res.filter(!_.isEmpty)
  }
}
