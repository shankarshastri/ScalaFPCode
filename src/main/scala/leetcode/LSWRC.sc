
//import scala.annotation.tailrec
////Given "abcabcbb", the answer is "abc", which the length is 3.
////
////Given "bbbbb", the answer is "b", with the length of 1.
////
////Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
////
//
//
//val x = "abcabcbb"
//119.toChar
//val mutableMap = scala.collection.mutable.Map[Int, Int]().withDefaultValue(-1)
//var max = 0
//x.substring(1)
//@tailrec
//def func(str: String, accumString: String="", index:Int = 0): String = {
//  if(str.length == 1) {
//    println(accumString)
//    if(mutableMap(str.head) == 1) {
//      val res = str.head.toString + accumString
//      max = Math.max(max, res.length)
//      res
//    }
//    else {
//
//      val res = accumString
//      max = Math.max(max, res.length)
//      res
//
//    }
//  }
//  else {
//    val head = mutableMap(str.head)
//    if(head == -1) {
//      mutableMap.put(str.head, index)
//      println("1")
//      println(mutableMap)
//      println(str)
//      func(str.tail, str.head.toString + accumString, index+1)
//    } else if(head != -1 && head < index) {
//      mutableMap.put(str.head, index)
//      println("2")
//      println(accumString)
//      max = Math.max(max, accumString.length)
//      func(str.tail, str.head.toString, index+1)
//    } else{
//        max = Math.max(max, accumString.length)
//        mutableMap.put(str.head, index)
//      println("3")
//      println(str.substring(head -1))
//        func(str.substring(head -1), "", index+1)
//      }
//    }
//  }
//func(x)
//max
