/**
  * @author ShankarShastri
  *         Algorithm: PickingCoins
  *         (https://www.hackerearth.com/challenge/competitive/december-circuits-18/algorithm/picking-the-coins-50470dca/)
  */

package contests.hackerearth

import scala.io.StdIn._
import scala.annotation.tailrec

object codeOpsPickingCoins {
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  @tailrec
  def pickCoins(n: BigInt, k: BigInt, index: Int = 1): String = {
    val powerOfIndex = k.pow(index)
    n - (powerOfIndex *2) match  {
      case x if x < 0 => (n - powerOfIndex) match {
        case x1 if x1 < 0 => "Bob"
        case _ => "Alice"
      }
      case x => pickCoins(x, k, index+1)
    }
  }
}

object PickingCoins {
  import codeOpsPickingCoins._
  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    loop(t) {
      val Array(n,k) = readLine.split(" ").map(BigInt(_))
      println(pickCoins(n, k))
    }
  }
}
