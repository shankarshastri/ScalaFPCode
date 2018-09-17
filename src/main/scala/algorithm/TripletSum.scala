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
  
  def tripleSumHelper(l: List[BigInt], s: BigInt): List[(BigInt,BigInt,BigInt)]  ={
    val res = for {
      i <- 0 to l.length - 2
    } yield {
      val curr_sum = (s - l(i))
      (i+1 until l.length)
        .foldLeft(
          (Set[BigInt](), List[(BigInt, BigInt, BigInt)]()))((a,b) => {
          val sumInSet = (curr_sum - l(b)).abs
          a._1.find(_ == sumInSet) match {
            case Some(e) => (a._1 + l(b), (l(i), e, l(b)) ::  a._2)
            case _ => (a._1 + l(b) , a._2)
          }
        })
    }
    res.flatMap(e => e._2).toList
  }
  
  def tripleSum(n: BigInt): List[(BigInt,BigInt,BigInt)]  = {
    tripleSumHelper(List.tabulate(n.toInt)(e => BigInt(e + 1)), n)
  }
}
