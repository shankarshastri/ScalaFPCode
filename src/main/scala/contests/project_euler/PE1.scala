/**
  * @author ShankarShastri
  *         Algorithm: PE1
  */

package contests.project_euler

import scala.io.StdIn._


object PE1 {
  
  def calcMulN(num: BigInt, n: BigInt) = {
    val res = if(num % n == 0 ) num/n - 1 else num/n
    (n * res * (res+1))/2
  }
  
  def main(args: Array[String]): Unit = {
    val n = readInt
    (1 to n).foreach(_ => {
      val num = readInt
      println(calcMulN(num, 3) + calcMulN(num, 5) -  calcMulN(num, 15))
    })
  }
}


//n(n+1)/2
