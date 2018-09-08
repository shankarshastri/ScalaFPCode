val arr = Array.fill(10)(0)
val updatedValue = 100
(0 to 1).foreach(e =>  arr.update(e, arr(e) + 100))
arr


import java.io._
object Solution {
  
  // Complete the arrayManipulation function below.
  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    val arr = Array.fill(n+1)(BigInt(0))
    queries.foreach{
        e => {
          val Array(a, b, k) = e
          (a to b).foreach(ele => arr.update(ele, arr(ele) + k))
        }
    }
    arr.max.longValue()
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val nm = stdin.readLine.split(" ")
    val n = nm(0).trim.toInt
    val m = nm(1).trim.toInt
    val queries = Array.ofDim[Int](m, 3)
    for (i <- 0 until m) {
      queries(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }
    val result = arrayManipulation(n, queries)
    printWriter.println(result)
    printWriter.close()
  }
}
