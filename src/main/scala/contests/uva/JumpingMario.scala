/**
  * @author ShankarShastri
  *         Algorithm: JumpingMario (https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2864)
  */
import scala.io.StdIn._

object JumpingMario {
  def main(args: Array[String]): Unit = {
    val n = readLine().toInt
    loopWithIndex(n) { i =>
      readLine
      val l = readLine.split(" ").map(_.toInt).toList
      if (l.lengthCompare(1) == 0) {
        println(s"Case ${i}: 0 0")
      } else {
        val res = l
          .sliding(2)
          .foldLeft((0, 0))((a, b) => {
            if (b.head > b.tail.head) a.copy(_2 = a._2 + 1)
            else if (b.head < b.tail.head) a.copy(_1 = a._1 + 1)
            else a
          })
        println(s"Case ${i}: ${res._1} ${res._2}")
      }
    }
  }
  
  def loopWithIndex[T](n: Int)(block: Int => T) =
    (1 to n).foreach(e => block(e))
}