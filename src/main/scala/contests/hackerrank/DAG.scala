/**
  * @author ShankarShastri
  *         Algorithm: DAG
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.collection.SortedMap

object DAG {
  def printDag(m: SortedMap[Int, (List[Int], Boolean)]):Unit = {
    m.foreach(e => {
      if(e._2._2) {
        val f = e._1
        if (e._2._1.nonEmpty) {
          e._2._1.foreach(k => {
            val s = k
            m(k)._1.foreach(t => println(s"${f}->${s}->${t}"))
          })
        }
        else {
          println(e._1)
        }
      }
    })
  }
  
  def main(args: Array[String]): Unit = {
    val t = readLine.trim.toInt
    val (m, s) = (1 to t-1).foldLeft((SortedMap[Int, List[Int]](), Set[Int]()))((a, _) =>  {
      val Array(k, v) = readLine.split(",").map(_.trim.toInt)
      (a._1.updated(k, v :: a._1.getOrElse(k, List[Int]())), a._2 + v)
    })
    
    val markZeroDegreeMap = SortedMap.empty[Int, (List[Int], Boolean)] ++
      (0 until t).map(e => (e , (m.getOrElse(e, List[Int]()).sorted, !s.contains(e)))).toMap
    printDag(markZeroDegreeMap)
  }
}
