/**
  * @author ShankarShastri
  *         Algorithm: LSWRC (https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)
  */

package leetcode

object LSWRC {
  def main(args: Array[String]): Unit = {
    //import scala.annotation.tailrec
    //import scala.util.Try
    ////
    ////val str = "dvdf"
    ////
    ////
    ////val countMap = Map[Int, Boolean]().withDefaultValue(false)
    ////
    ////countMap('x')
    ////
    ////
    ////def getLSWRC(str: String): List[String] = {
    ////  @tailrec
    ////  def getLSWRCHelper(str: String,
    ////                     map: Map[Int, Boolean] = Map[Int, Boolean]().withDefaultValue(false),
    ////                     accumString: String = "",
    ////                     accumListStr: List[String]= List[String]()): List[String] = {
    ////    if(str.length == 1) {
    ////      if(!map(str.head)) {
    ////        accumString + str.head.toString :: accumListStr
    ////      }
    ////      else {
    ////        accumString :: accumListStr
    ////      }
    ////    }
    ////    else {
    ////      println(str)
    ////      if(!map(str.head)) {
    ////        getLSWRCHelper(str.tail, map.updated(str.head, true),
    ////          str.head.toString + accumString, accumListStr)
    ////      } else {
    ////        getLSWRCHelper(str.tail,
    ////          Map[Int, Boolean]().withDefaultValue(false),
    ////          str.head.toString, accumString :: accumListStr)
    ////      }
    ////    }
    ////  }
    ////  getLSWRCHelper(str)
    ////}
    ////
    ////getLSWRC(str)
    //
    //
    //
    ////def getLSWR(str: String, max: Int = 0) = {
    ////  if(str.length == 0) {
    ////    0
    ////  } else if(str.length == 1) {
    ////    if(max < 1) 1
    ////    else max
    ////  }
    ////  getLSWR(str.tail, str)
    ////}
    ////
    ////
    //val x = "dvdf"
    //x(0)
    //
    //
    //val list = (for {
    //  i <- 0 to x.length
    //  j <- x.length to 0 by -1
    //  if(i<j)
    //} yield {
    //  val subs = x.substring(i,j)
    //  if(subs.length == subs.distinct.length) subs.length else 0
    //}).max
    //
    //def lswrc(str: String): Int = {
    //  (for {
    //    i <- 0 to str.length
    //    j <- str.length to 0 by -1
    //    if(i<j)
    //  } yield {
    //    val subs = str.substring(i,j)
    //    if(subs.length == subs.distinct.length) subs.length else 0
    //  }).par.max
    //}
    //Try(lswrc(x)).getOrElse(0)
    //

  }
}
