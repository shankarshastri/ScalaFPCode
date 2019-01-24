/**
  * @author ShankarShastri
  *         Algorithm: EdgeExistence
  */

package contests.hackerearth

import scala.io.StdIn._
import scala.annotation.tailrec

object codeOpsEdgeExistence {
  def readLineToList(str: String = readLine) = str.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
  
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
  
  def rotateList[T](ls: List[T], rotateCount: Int): List[T] = {
    (1 to rotateCount).foldLeft(ls)((a, _) => {
      val (l1, l2) = a.splitAt(a.length - 1)
      l2 ::: l1
    })
  }
}

object EdgeExistence {
  @tailrec
  def tailRecMatrix(n: Int, res: Map[Int, Map[Int, Boolean]] =
      Map[Int, Map[Int, Boolean]]()
        .withDefaultValue(Map[Int, Boolean]()
          .withDefaultValue(false))):Map[Int, Map[Int, Boolean]] = {
    if(n <= 0) res
    else
      {
        val Array(a,b) = readLine.split(" ").map(_.toInt)
        tailRecMatrix(n-1, res.updated(a, res.getOrElse(a, Map[Int, Boolean]()).updated(b, true)))
      }
  }
  
  @tailrec
  def tailRecQuery(q: Int, m: Map[Int, Map[Int, Boolean]]): Unit = {
    if(q <= 0) ()
    else {
      val Array(a,b) = readLine.split(" ").map(_.toInt)
      m.get(a) match {
        case Some(m) if m.getOrElse(b, false) == true => println("YES")
        case _ => println("NO")
      }
      tailRecQuery(q-1, m)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val Array(_, m) = readLine.split(" ").map(_.toInt)
    val res = tailRecMatrix(m)
    val q = readLine.toInt
    tailRecQuery(q, res)
  }
}
