package contests.hackerearth

object DifferencePermutations extends App {
  def calc(k: Int): Int =
    ((k * k) - (1 to k).sum) * (1 to k).reduce(_ * _)

  import scala.io.StdIn._

  val t = readInt
  (1 to t).foreach {
    _ => {
      println(calc(readInt))
    }
  }
}
