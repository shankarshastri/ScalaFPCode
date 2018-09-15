/**
  * @author ShankarShastri
  *         Algorithm: StringCompression
  */

package contests.hackerrank

import scala.annotation.tailrec
import scala.io.StdIn._
object StringCompression {
  
  def strCompressFoldLeft(s: String): String = {
    val res = s.foldLeft(("", '$', 1))((a,b) => {
      if(a._2 == b) {
        (a._1, a._2, a._3+1)
      }
      else {
        (a._1 + a._2 + a._3, b, 1)
      }
    })
    (res._1 + res._2 + res._3).filter(_ != '1').tail
  }
  
  def strCompress(s: String): String = {
    @tailrec
    def strCompressHelper(s: List[Char], result: List[(Char, Int)] = List()): String  ={
      s match {
        case Nil => result.reverse.map(_._1).toString
        case head :: Nil if !result.isEmpty && head == result.head._1 =>
          val l = result.head
          (result.head.copy(_2 = l._2+1) :: result.tail).reverse.map(e => {
            if(e._2 == 1)
              e._1.toString
            else e._1.toString + e._2.toString
          }).mkString
        case head :: Nil if !result.isEmpty && head != result.head._1 =>
          s"${result.reverse.map(e => {
            if(e._2 == 1)
              e._1.toString
            else e._1.toString + e._2.toString
          }).mkString}${head.toString}"
        case head :: Nil => head.toString
        case head :: tail if !result.isEmpty && head == result.head._1 =>
          val l = result.head
          strCompressHelper(tail, result.head.copy(_2 = l._2+1) :: result.tail)
        case head :: tail if !result.isEmpty =>
          strCompressHelper(tail, (head, 1) :: result)
        case head :: tail =>
          strCompressHelper(tail, (head, 1) :: result)
      }
    }
    strCompressHelper(s.toCharArray.toList)
  }
  
  def main(args: Array[String]): Unit = {
    println(strCompress(readLine))
  }
}