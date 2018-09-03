import scala.annotation.tailrec

val l = "0 0 0 0 1 0".split(" ").map(_.toInt).toList

//https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
@tailrec
def jumpOnClouds(l: List[Int], cumResult: List[Int] = List[Int]()): Int = {
  cumResult match {
    case Nil => l match {
      case head :: tail if head == 0 =>
        jumpOnClouds(tail, 1 :: cumResult)
      case _ :: tail => jumpOnClouds(tail, 0 :: cumResult)
    }
    case _ => l match {
      case head :: Nil if cumResult.head == 0 && head == 0
        || cumResult.head == 0 && head == 1 =>
        cumResult.filter(_ == 1).length + 1
      case _ :: Nil => cumResult.filter(_ == 1).length
      case head :: tail if cumResult.head == 0 && head == 0
        || cumResult.head == 0 && head == 1 =>
        jumpOnClouds(tail, 1 :: cumResult)
      case _ :: tail => jumpOnClouds(tail, 0 :: cumResult)
    }
  }
}



import java.io._
import scala.annotation.tailrec
object Solution {
  
  @tailrec
  def jumpOnClouds(l: List[Int], cumResult: List[Int] = List[Int]()): Int = {
    cumResult match {
      case Nil => l match {
        case head :: tail if head == 0 =>
          jumpOnClouds(tail, 1 :: cumResult)
        case _ :: tail => jumpOnClouds(tail, 0 :: cumResult)
      }
      case _ => l match {
        case head :: Nil if cumResult.head == 0 && head == 0
          || cumResult.head == 0 && head == 1 =>
          cumResult.filter(_ == 1).length + 1
        case _ :: Nil => cumResult.filter(_ == 1).length
        case head :: tail if cumResult.head == 0 && head == 0
          || cumResult.head == 0 && head == 1 =>
          jumpOnClouds(tail, 1 :: cumResult)
        case _ :: tail => jumpOnClouds(tail, 0 :: cumResult)
      }
    }
  }
  
  def jumpingOnClouds(c: Array[Int]): Int = {
    jumpOnClouds(c.toList)
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val n = stdin.readLine.trim.toInt
    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)
    printWriter.println(result)
    printWriter.close()
  }
}
