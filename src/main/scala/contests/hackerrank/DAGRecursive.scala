/**
  * @author ShankarShastri
  *         Algorithm: DAGRecursive
  */

package contests.hackerrank

import scala.io.StdIn._


/**
  * @author ShankarShastri
  *         Algorithm: DAG
  */
import scala.collection.SortedMap

object DAGRecursive {
  def printDag(m: SortedMap[Int, List[Int]]):Unit = {

  }
  
  def main(args: Array[String]): Unit = {
    val t = readLine.trim.toInt
    val (m, s) = (1 to t-1).foldLeft((SortedMap[Int, List[Int]](), Set[Int]()))((a, _) =>  {
      val Array(k, v) = readLine.split(",").map(_.trim.toInt)
      (a._1.updated(k, v :: a._1.getOrElse(k, List[Int]())), a._2 + v)
    })
    
    val markZeroDegreeMap = SortedMap.empty[Int, List[Int]] ++
      (0 until t).map(e => (e , m.getOrElse(e, List[Int]()).sorted)).filter(e => !s.contains(e._1)) .toMap
    printDag(markZeroDegreeMap)
  }
}
