package programming


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._


object Pr5 {


  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val fut = Future.sequence((1 to scala.io.StdIn.readInt).map(_ =>
      Future {
        evenOddPermute(scala.io.StdIn.readLine)
      }))

  }

  def evenOddPermute(str: String, accumString: String = ""): String = {
    str.grouped(2).flatMap(_.reverse).mkString
  }
}