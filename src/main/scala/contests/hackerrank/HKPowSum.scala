import scala.annotation.tailrec

object HKSum {

  @tailrec
  def constructPowerList(n: Int,
                         max: Int,
                         accumList: List[Double] = List[Double](),
                         index: Int = 1): List[Int] = {
    val powVal = Math.pow(index, n)
    if (powVal <= max) {
      constructPowerList(n, max, powVal :: accumList, index + 1)
    } else accumList.map(_.toInt)
  }

  def powerSetSum(t: Set[Int], sum: Int): Int = {
    @tailrec
    def pwr(t: Set[Int], ps: Set[Set[Int]], count: Int = 0): Int = {
      if (t.isEmpty) count
      else {
        val set = (ps map (x => x + t.head))
        pwr(t.tail, ps ++ (set), count + set.count(_.sum == sum))
      }
    }
    pwr(t, Set(Set.empty[Int]))
  }

  // Complete the powerSum function below.
  def powerSum(X: Int, N: Int): Int = {
    val values = constructPowerList(N, X)
    powerSetSum(values.toSet, X)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val X = stdin.readLine.trim.toInt
    val N = stdin.readLine.trim.toInt
    val result = powerSum(X, N)
    println(result)
  }
}
//  @tailrec
//  def constructPowerMap(n: Double, max: Double,
//                        accumMap: Map[Double, Double] = Map[Double, Double](),
//                        index: Double=1): Map[Double, Double]  = {
//    val powVal = Math.pow(index, n)
//    if(powVal <= max) {
//      constructPowerMap(n, max, accumMap + (index -> powVal), index + 1)
//    } else accumMap
//  }
//
//  @tailrec
//  def constructPowerList(n:Int, max:Int, accumList: List[Double] = List[Double](),
//                         index:Int = 1 ): List[Int] = {
//    val powVal = Math.pow(index, n)
//    if(powVal <= max) {
//      constructPowerList(n, max, powVal :: accumList ,index+1)
//    } else accumList.map(_.toInt)
//  }
//
//  // Complete the powerSum function below.
//  def powerSum(X: Int, N: Int): Int = {
//    val values = constructPowerList(N, X)
//    values.toSet.subsets().toStream.map(_.sum).count(_ == X.toDouble)
//  }
