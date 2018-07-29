/**
  * @author ShankarShastri
  *         Algorithm: PE5
  */

package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object PE5 {
  val collectedMap = (1 to 40).zip(List[BigInt](1,2,3,2,5,1,7,2,3,1,11,1,13,1,1,2,17,1,19,1,1,1,23,1,5,1,3,1,29,1,
    31,2,1,1,1,1,37,1,1,1)).toMap
  
  @tailrec
  def loopWithResForBigInt[T](n: BigInt)(block: => T)(res: List[T] = List[T]()): List[T] = {
    n match {
      case x: BigInt if x == BigInt(0) => res
      case _ => loopWithResForBigInt(n-1)(block)(block :: res)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val t = readInt
    loopWithResForBigInt(t) {
      val n = readInt
      println(collectedMap.filter(_._1 <= n).map(_._2).product)
    }()
    
  }
}
