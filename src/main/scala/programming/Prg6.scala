package programming

import scala.annotation.tailrec

object Pr6 {

  def main(args: Array[String]) {
    (1 to scala.io.StdIn.readInt()).foreach(_ =>
      printf("%.4f", `e^`(scala.io.StdIn.readDouble())))
  }

  def `e^`(x: Double) = {
    (1 to 10).zipWithIndex.map(num => Math.pow(x, num._2) / fact(num._2)).sum
  }

  def fact(n: Int): Int = {
    @tailrec
    def factHelper(n: Int, res: Int = 1): Int = {
      if (n == 0 || n == 1) res
      else factHelper(n - 1, n * res)
    }

    factHelper(n)
  }
}
