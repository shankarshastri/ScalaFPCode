/**
  * @author ShankarShastri
  *         Algorithm: PicuBank
  */

package contests.hackerearth

import scala.io.StdIn._
import scala.annotation.tailrec

object PicuBank {
  def loopWithReadLine[T](n: Int)(block: String => T): Unit =
    (1 to n).map(_ => {
      println(block(readLine))
    })
  
  def calcResultForX(X: BigInt, a: BigInt, b: BigInt): BigInt = {
    @tailrec
    def calcResultForXHelper(index: BigInt, result: BigInt = 0): BigInt = {
      if(result > X) {
        val resA = (X - (result - a - b)).abs
        val resB = (X - (result - b)).abs
        resA min resB match {
          case r if r == resA =>
            (index - 2) * 2
          case r if r == resB => ((index - 1) * 2) - 1
        }
      } else {
        calcResultForXHelper(index+1, result+a+b)
      }
    }
    calcResultForXHelper(1)
  }
  
  def picuBank(d: BigInt, m: BigInt, a: BigInt, b: BigInt, x:BigInt): BigInt = {
    val calcX = x - (d + a * m)
    if(calcX < 0) m
    else m + calcResultForX(calcX, a, b)
  }
  
  def main(args: Array[String]): Unit = {
    val t = readInt
    loopWithReadLine[BigInt](t){
      (s: String) => {
        val Array(d,a,m,b,x) = s.split(" ").map(_.toInt)
        //50 40 35 15 150
        picuBank(d, m, a, b, x) //50 35 40 15 150
      }
    }
  }
}
