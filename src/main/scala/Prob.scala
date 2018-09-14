/*
// Sample code to perform I/O:

val name = scala.io.StdIn.readLine()        // Reading input from STDIN
println("Hi, " + name + ".")                // Writing output to STDOUT

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
*/

// Write your code here
object SolutionProb {
  def main(args: Array[String]):Unit =  {
    import scala.io.StdIn._
    val pmb = readDouble
    val pab = readDouble
    val p1 = readDouble
    val result = BigDecimal(p1 * (pmb * (1-pab) + pab*(1-pmb))).setScale(6, BigDecimal.RoundingMode.HALF_UP)
    println(result)
  }
}