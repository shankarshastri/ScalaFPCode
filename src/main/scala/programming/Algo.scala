package programming

import scala.collection.immutable.Stack

object Algo extends App {


  val paranthesisReverseHelper: PartialFunction[Char, Char] = {
    case '}' => '{'
    case '(' => ')'
    case '[' => ']'
  }

  // 2) Find Missing Number
  // Can also be achieved with XOR of both lists
  def findNumberMissing(arrList: List[Int], lastDigit: Int): List[Int] = {
    val missingNumberList = (1 to lastDigit).toList
    missingNumberList.filterNot(arrList.contains(_))
  }

  import scala.util.control.Breaks._

  def findNumberMissingWithMath(arrList: List[Int], lastDigit: Int): Int = {
    (lastDigit * (lastDigit + 1) / 2) - arrList.sum
  }

  // 3) SubArray With Sum
  def subArrayWithSum(arrList: List[Int], sum: Int) = {
    var result = (0, 0);
    for (i <- 0 until arrList.length) {
      var sumCalc = arrList(i)
      breakable {
        for (j <- i + 1 until arrList.length) {
          if (sumCalc == sum) result = (i, j - 1)
          else if (sumCalc > sum) break
          else sumCalc += arrList(j)
        }
      }
    }
    result
  }

  // Take A Look AT This Function Need To Fix The Logic
  def subArrayWithSumWithNegative(arrList: List[Int], sum: Int) = {
    var result = (0, 0);
    breakable {
      for (i <- 0 until arrList.length) {
        var sumCalc = arrList(i)
        for (j <- i + 1 until arrList.length) {
          sumCalc += arrList(j)
          if (sumCalc == sum) result = (i, j); break;
        }
      }
    }
    result
  }

  def paranthesisChecker(s: String): Boolean = {
    var stackParnthesis = Stack.empty
    var flag = true;
    breakable {
      s.foreach { x =>
        x match {
          case '{' | '[' | '(' => stackParnthesis.push(x)
          case '}' | ']' | ')' => {
            if (stackParnthesis.pop != paranthesisReverseHelper(x)) flag = false;
            break;
          }
        }
      }
    }
    flag || stackParnthesis.isEmpty
  }

  //5) ReverseWords Of Strings
  def reverseWordsOfString(s: String) = {
    s.split(" ").map(_.reverse).mkString(" ")
  }

  //Longest Palindrome sequence => Need To Understand Manacher Algorithm
  //https://www.hackerearth.com/practice/algorithms/string-algorithm/manachars-algorithm/tutorial/
  def longestPalindromeSequence(str: String) = {
    var longPalindromeSequence = ""
    if (str == str.reverse) str
    else {
      for (i <- 0 until str.length) {
        for (j <- i + 1 until str.length) {
          val subStrIJ = str.substring(i, j)
          if (subStrIJ == subStrIJ.reverse && subStrIJ.length > longPalindromeSequence.length) {
            longPalindromeSequence = subStrIJ
          }
        }
      }
      longPalindromeSequence
    }
  }

  def anagramChecker(str1: String, str2: String) = {
    val map1 = strPerCharCount(str1)
    val map2 = strPerCharCount(str2)
    map1.zip(map2)
  }

  def strPerCharCount(s: String) = {
    s.toCharArray.map(x => (x, s.count(_ == x))).toMap
  }

  def maxUnsortedSubArray(arrList: List[Int]): Int = {
    val (firstElement, indexFirstElement) = arrList.zipWithIndex.max
    val remainingList = arrList.takeRight(arrList.length - indexFirstElement - 1)
    if (remainingList.length == 0) {
      arrList.take(arrList.length - indexFirstElement).max + firstElement
    } else {
      remainingList.max + firstElement
    }
  }
}
