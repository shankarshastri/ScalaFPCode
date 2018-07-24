/**
  * @author ShankarShastri
  *         Algorithm: Karatsuba-Algorithm
  */

package algorithm

object KaratsubaAlgorithm {
  
  def karatsubaMultiplication(x: BigInt, y: BigInt): BigInt = {
    val m = x.abs.toString.length max y.abs.toString.length
    if (m < 10) x * y
    else {
      val mid = (m / 2) + (m % 2)
      val xSplit = x.abs.toString.splitAt(mid)
      val ySplit = y.abs.toString.splitAt(mid)
      val (high1, low1) = (BigInt(xSplit._1), BigInt(xSplit._2))
      val (high2, low2) = (BigInt(ySplit._1), BigInt(ySplit._2))
      val z0 = karatsubaMultiplication(low1, low2)
      val z1 = karatsubaMultiplication(low1 + high1, low2 + high2)
      val z2 = karatsubaMultiplication(high1, high2)
      val res = (z2 * BigInt(10).pow(mid * 2)) + ((z1 - z2 - z0)) * BigInt(10).pow(mid) + z0
      if (x < 0 && y < 0 || x > 0 && y > 0) res
      else res * -1
    }
  }
  
  def main(args: Array[String]): Unit = {
    karatsubaMultiplication(81, 81)
  }
}
