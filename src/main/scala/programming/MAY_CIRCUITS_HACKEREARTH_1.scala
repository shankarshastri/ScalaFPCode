package programming


import scala.io.StdIn._

object MAY_CIRCUITS_HACKEREARTH_1 {

  def main(args: Array[String]): Unit = {
    //    3 2
    //    1 2 4
    val Array(n, k) = readLine.split(" ").map(_.toInt)
    val arrElem = readLine.split(" ").map(_.toInt).toSet
    println(powerSet(arrElem))
  }

  def powerSet(t: Set[Int]): Set[Set[Int]] = {
    @annotation.tailrec
    def pwr(t: Set[Int], ps: Set[Set[Int]]): Set[Set[Int]] = {
      if (t.isEmpty) ps
      else pwr(t.tail, ps ++ Set((ps.map(x => x + t.head).map(x => x.reduce((a, b) => a | b)))))
    } //_ + t.head)
    pwr(t, Set(Set.empty[Int]))
  }

}
