import scala.math._
def maxSum(l: List[Int], sum: Int): Int = {
  l match {
    case head :: Nil => sum + head
    case head :: tail => max(maxSum(tail, sum + head),
      maxSum(tail, sum))
  }
}
val l = List(-2, 1, 3, -4, 5)
val res = l.zipWithIndex.partition(e => e._2 % 2 == 0)


max(maxSum(res._1.map(e => e._1), 0),
  maxSum(res._2.map(e => e._1), 0))



import java.io._

object Solution {

  def maxSum(l: List[Int], sum: Int): Int = {
    l match {
      case head :: Nil => sum + head
      case head :: tail => max(maxSum(tail, sum + head),
        maxSum(tail, sum))
    }
  }

  def maxSubsetSum(arr: Array[Int]): Int = {
    val res = arr.zipWithIndex.partition(e => e._2 % 2 == 0)
    max(maxSum(res._1.map(e => e._1).toList, 0),
      maxSum(res._2.map(e => e._1).toList, 0))
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val res = maxSubsetSum(arr)

    printWriter.println(res)

    printWriter.close()
  }
}
