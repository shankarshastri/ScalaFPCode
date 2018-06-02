package contests.codeforces.cf_481

object CF_481_1 extends App {

  val numOfElements = scala.io.StdIn.readLine.toInt
  val elements = scala.io.StdIn.readLine.split(" ").map(_.toInt).toList.reverse.distinct.reverse
  println(elements.length)
  println(elements.mkString(" "))
  //1 5 5 1 6 1
}
