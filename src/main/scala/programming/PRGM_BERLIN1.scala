package programming


import scala.io.StdIn._

object PRGM_BERLIN1 {

  def main(args: Array[String]): Unit = {
    val inputString = readLine
    val listString = replaceNonCharsAndSplitToList(inputString)
    val listOfLengthOfString = listString.map(eachStr => eachStr
      .trim
      .split(' ')
      .filter(_.matches(".*[a-zA-Z]+.*"))
      .length)
    println(listOfLengthOfString.max)
  }

  def replaceNonCharsAndSplitToList(str: String): List[String] = {
    str.replace('.', '$').replace('?', '$')
      .replace('!', '$').split('$').toList
  }
}


//import scala.collection.JavaConverters._
//
//// you can write to stdout for debugging purposes, e.g.
//// println("this is a debug message")
//
//object Solution {
//  def replaceNonCharsAndSplitToList(str: String): List[String] = {
//    str
//      .replace('.', '$')
//      .replace('?', '$')
//      .replace('!', '$')
//      .split('$')
//      .toList
//  }
//
//  def solution(s: String): Int = {
//    // write your code in Scala 2.12
//    val listString = replaceNonCharsAndSplitToList(s)
//    val listOfLengthOfString = listString.map(
//      eachStr =>
//        eachStr.trim
//          .split(' ')
//          .filter(_.matches(".*[a-zA-Z]+.*"))
//          .length)
//    listOfLengthOfString.max
//  }
//}
