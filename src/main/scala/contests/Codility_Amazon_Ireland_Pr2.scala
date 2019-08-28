package contests

import scala.annotation.tailrec

object Codility_Amazon_Ireland_Pr2 {
  @tailrec
  def calcInterval(l: List[(Int, Int)], disjointCount: Int = 0, overlapCount: Int = 0): Int = {
    l match {
      case Nil => 0
      case _ :: Nil => disjointCount + overlapCount + 1
      case h :: h1 :: Nil =>
        if(h1._1 <= h._2)
          disjointCount + overlapCount + 1
        else
          disjointCount + overlapCount + 1
      case h :: h1 :: tail =>
        if(h1._1 <= h._2)
          calcInterval(tail, disjointCount, overlapCount + 1)
        else
          calcInterval(h1 :: tail, disjointCount + 1, overlapCount)
    }
  }


  def solution(a: Array[Int], b: Array[Int]): Int = {
    calcInterval((a zip b).toList.sortBy(_._1))
  }

  def main(args: Array[String]): Unit = {
    val l =  List((1,5), (12, 15), (42, 44), (70, 72), (36, 36), (-4, 2), (43, 69), (15,24))
    println(calcInterval(l.sortBy(_._1)))
  }
}
