/**
  * @author ShankarShastri
  *         Algorithm: GetAllFactors
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec
object GetAllFactors {
  def getAllFactors(n: BigInt): List[BigInt] = {
    if(n.isProbablePrime(1)) List(n)
    else {
      (BigInt(1) :: ((BigInt(2) to BigInt(9))
        .filter(n%_ == 0)
        .flatMap(i => n/i :: i :: getAllFactors(n/i)).toList :+ n))
        .sorted
        .distinct
    }
  }
  
  def main(args: Array[String]): Unit = {
   println(getAllFactors(100000))
  }
}
