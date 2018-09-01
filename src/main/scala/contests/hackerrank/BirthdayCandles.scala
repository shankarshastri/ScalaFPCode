/**
  * @author ShankarShastri
  *         Algorithm: BirthdayCandles
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec
import java.io._

object BirthdayCandles {
  
  // Complete the birthdayCakeCandles function below.
  def birthdayCakeCandles(ar: Array[Int]): Int = {
    val maxElement = ar.max
    ar.count(_ == maxElement)
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val arCount = stdin.readLine.trim.toInt
    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = birthdayCakeCandles(ar)
    
    printWriter.println(result)
    
    printWriter.close()
  }
}
