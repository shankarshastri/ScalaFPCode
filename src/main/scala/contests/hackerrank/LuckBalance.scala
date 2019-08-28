package contests.hackerrank
import scala.collection.mutable.PriorityQueue
import scala.io.StdIn._
object LuckBalance {
//  6 3
//  5 1
//  2 1
//  1 1
//  8 1
//  10 0
//  5 0


  def main(args: Array[String]): Unit = {
    val Array(n, k) = readLine.split(" ").map(_.toInt)
    val (acc, resPrioQueue) = (1 to n).foldLeft((0, PriorityQueue[Int]()))((a, _) => {
      val Array(c, i) = readLine.split(" ").map(_.toInt)
      if(i == 0) (a._1 + c, a._2)
      else {
        a._2.enqueue(c)
        a
      }
    })
    val (addL, subL) = resPrioQueue.dequeueAll.splitAt(k)
    println(acc + addL.sum - subL.sum)
  }
}
