package contests

object Codility_Amazon_Ireland {

  import scala.collection.JavaConverters._
  import scala.annotation.tailrec
  // you can write to stdout for debugging purposes, e.g.
  // println("this is a debug message")

  object Solution {
    def solution(a: Int, b: Int): String = {
      // write your code in Scala 2.12
      val noOfDoubleA = a/2
      val noOfSingleA = a % 2
      val noOfDoubleB = b/2
      val noOfSingleB = b % 2
      val doubleA = "aa"
      val doubleB = "bb"
      val singleA = "a"
      val singleB = "b"

      @tailrec
      def solutionHelper(startA: Boolean, noOfDoubleA: Int, noOfDoubleB: Int, noOfSingleA: Int, noOfSingleB: Int, res: String = ""): String = {
        if(noOfDoubleB == 0 && noOfDoubleA == 0 && noOfSingleA == 0 && noOfSingleB == 0) res
        else {
          if(startA) {
            if(noOfDoubleA > 0)
              solutionHelper(false, noOfDoubleA - 1, noOfDoubleB, noOfSingleA, noOfSingleB, res + doubleA)
            else
              solutionHelper(false, noOfDoubleA, noOfDoubleB, noOfSingleA - 1, noOfSingleB, res + singleA)
          } else {
            if(noOfDoubleB > 0)
              solutionHelper(true, noOfDoubleA, noOfDoubleB - 1, noOfSingleA, noOfSingleB, res + doubleB)
            else
              solutionHelper(true, noOfDoubleA, noOfDoubleB, noOfSingleA, noOfSingleB - 1, res + singleB)
          }
        }
      }

      if(a < b) {
        solutionHelper(false, noOfDoubleA, noOfDoubleB, noOfSingleA, noOfSingleB)
      } else {
        solutionHelper(true, noOfDoubleA, noOfDoubleB, noOfSingleA, noOfSingleB)
      }
    }
  }

}
