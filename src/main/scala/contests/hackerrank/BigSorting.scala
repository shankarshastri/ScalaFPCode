/**
  * @author ShankarShastri
  *         Algorithm: BigSorting(https://www.hackerrank.com/challenges/big-sorting/problem)
  */

package contests.hackerrank
import java.io._

object BigSorting {
  
  // Complete the bigSorting function below.
  def bigSorting(unsorted: Array[String]): Array[String] = {
    unsorted.sorted.sortBy(_.size)
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    
    val n = stdin.readLine.trim.toInt
    
    val unsorted = Array.ofDim[String](n)
    
    for (i <- 0 until n) {
      val unsortedItem = stdin.readLine
      unsorted(i) = unsortedItem}
    
    val result = bigSorting(unsorted)
    
    printWriter.println(result.mkString("\n"))
    
    printWriter.close()
  }
}
