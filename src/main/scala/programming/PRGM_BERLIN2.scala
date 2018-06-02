package programming

import scala.annotation.tailrec
import scala.io.StdIn._
import scala.util.Try

object PRGM_BERLIN2 {

  @tailrec
  def stitchStringToInt(f: String, l: String, accumString: String = ""): Int = {
    if (f.length == 1 && l.length == 1) (accumString + f + l).toInt
    if (f.length == 1 && l.length == 0) (accumString + f).toInt
    else if (l.length == 1 && f.length == 0) (accumString + l).toInt
    else if (f.length == 0 && l.length == 0) accumString.toInt
    else {
      val fOption = f.headOption.getOrElse("")
      val lOption = l.headOption.getOrElse("")

      stitchStringToInt(Try(f.tail).getOrElse(""), Try(l.tail).getOrElse(""), accumString + fOption + lOption)
    }
  }

  def main(args: Array[String]): Unit = {
    val inputString = readInt.toString
    val (f, l) = inputString.splitAt(inputString.length / 2)
    println(stitchStringToInt(f, l.reverse))
  }
}


//import scala.collection.JavaConverters._
//
//// you can write to stdout for debugging purposes, e.g.
//// println("this is a debug message")
//import scala.annotation.tailrec
//import scala.util.Try
//object Solution {
//  @tailrec
//  def stitchStringToInt(f: String, l: String, accumString: String = ""): Int = {
//    if (f.length == 1 && l.length == 1) (accumString + f + l).toInt
//    if (f.length == 1 && l.length == 0) (accumString + f).toInt
//    else if (l.length == 1 && f.length == 0) (accumString + l).toInt
//    else if (f.length == 0 && l.length == 0) accumString.toInt
//    else {
//      val fOption = f.headOption.getOrElse("")
//      val lOption = l.headOption.getOrElse("")
//
//      stitchStringToInt(Try(f.tail).getOrElse(""),
//        Try(l.tail).getOrElse(""),
//        accumString + fOption + lOption)
//    }
//  }
//  def solution(a: Int): Int = {
//    // write your code in Scala 2.12
//    val intInputToString = a.toString
//    val (f, l) = intInputToString.splitAt(intInputToString.length / 2)
//    stitchStringToInt(f, l.reverse)
//  }
//}
