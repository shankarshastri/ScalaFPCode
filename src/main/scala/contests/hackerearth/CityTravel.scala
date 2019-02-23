/**
  * @author ShankarShastri
  *         Algorithm: CityTravel
  */

package contests.hackerearth


import scala.annotation.tailrec
import scala.io.StdIn._

object CityTravel {
  
  def cityTravel(s: Int, d: Int, l: Map[Int, Int]):Int = {
    @tailrec
    def cityTravelHelper(s:Int, i: Int = 1):Int = {
      s match {
        case _ if s <=0 => i-1
        case _ => cityTravelHelper(s - l.getOrElse(i, d), i+1)
      }
    }
    cityTravelHelper(s)
  }
  
  def main(args: Array[String]): Unit = {
    val Array(s,x,n) = readLine().split(" ").map(_.toInt)
    val l =(1 to n).foldLeft(Map[Int, Int]())((accum, _) => {
      val Array(a,b) = readLine.split(" ").map(_.toInt)
      accum.updated(a,b)
    })
    println(cityTravel(s, x, l))
  }
}
