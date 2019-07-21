package contests.hackerrank

object BreakingTheRecords {
  def calcPoints(init: Int, f: (Int, Int) => Boolean, l: List[Int]): Int = {
    l.par.scanLeft(init)((a, b) => if (f(a, b)) a else b).tail.distinct.length - 1
  }

  def main(args: Array[String]): Unit = {
    import scala.io.StdIn._
    val _ = readLine
    val l = readLine.split(" ").map(_.toInt).toList
    val maxPoints = calcPoints(Int.MaxValue, _ < _, l)
    val minPoints = calcPoints(Int.MinValue, _ > _, l)
    println(List(minPoints, maxPoints).mkString(" "))
  }
}
