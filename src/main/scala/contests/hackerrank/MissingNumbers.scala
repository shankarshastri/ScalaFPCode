/**
  * @author ShankarShastri
  *         Algorithm: MissingNumbers
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec
import java.io._


object MissingNumbers {
  
  // Complete the missingNumbers function below.
  def missingNumbers(arr: Array[Int], brr: Array[Int]): Array[Int] = {
    (brr diff arr).sorted
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    
    val printWriter = new PrintWriter(System.out)
    
    val n = stdin.readLine.trim.toInt
    
    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val m = stdin.readLine.trim.toInt
    
    val brr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = missingNumbers(arr, brr)
    
    printWriter.println(result.mkString(" "))
    
    printWriter.close()
  }
}
