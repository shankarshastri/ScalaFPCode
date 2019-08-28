package contests.hackerrank

import java.io.PrintWriter

object GreedyFlorist {

  // Complete the getMinimumCost function below.
  def getMinimumCost(k: Int, c: Array[Int]): Int = {
    c
      .sortWith(_ > _)
      .grouped(k)
      .zipWithIndex
      .map(e => e._1.sum * (e._2 + 1))
      .sum
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val minimumCost = getMinimumCost(k, c)

    printWriter.println(minimumCost)

    printWriter.close()
  }
}

