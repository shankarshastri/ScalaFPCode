package programming


object Solution {
  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    def mingledString(x: => String, y: => String) = {
      x.zip(y).foldLeft("")((a, b) => a + b._1 + b._2)
    }

    println(mingledString(scala.io.StdIn.readLine, scala.io.StdIn.readLine))
  }
}