/**
  * @author ShankarShastri
  *         Algorithm: PE7
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object PE7 {
  
  @tailrec
  def loopWithResForBigInt[T](n: BigInt)(block: => T)(res: List[T] = List[T]()): List[T] = {
    n match {
      case x: BigInt if x == BigInt(0) => res
      case _ => loopWithResForBigInt(n-1)(block)(block :: res)
    }
  }
  
  def generatePrimeNumbers(n: BigInt): List[BigInt] = {
    val res = for {
      i <- BigInt(2) to BigInt(10002)
      if i.isProbablePrime(1)
    } yield i
    res.toList
  }
  
  def main(args: Array[String]): Unit = {
    
  }
}
