/**
  * @author ShankarShastri
  *         Algorithm: MonicaJavu
  */

package contests.hackerearth

import scala.io.StdIn._

object MonicaJavu {
  
  implicit class StringUtil(s: String) {
    def countMap: Map[Char, BigInt] = {
      s.foldLeft(Map[Char, BigInt]())((a,b) => a + (b -> (a.getOrElse(b, BigInt(0)) + BigInt(1)))).withDefaultValue(BigInt(-1))
    }
  }
  
  def op(s: Map[Char, BigInt], order: String): (BigInt, Map[Char, BigInt]) = {
    order.find(e => s.getOrElse(e, BigInt(0)) == BigInt(0)) match {
      case None => {
        val res = order.map(e => s.getOrElse(e, BigInt(0))).product  % 1000000007
        val m = order.foldLeft(s)((a,b) => {
          if(a.getOrElse(b, BigInt(0)) > BigInt(0))
            a + (b -> (a.getOrElse(b, BigInt(0)) - BigInt(1)))
          else a
        })
        (res, m)
      }
      case _ =>  (0, s)
    }
  }
  
  def main(args: Array[String]): Unit = {
    readLine
    val s = readLine
    val q = readLine.toInt
    (1 to q).foldLeft(s.countMap)((a,_) => {
      val qS = readLine()
       val r = op(a, qS)
      println(r._1)
      r._2
    })
  }
}
