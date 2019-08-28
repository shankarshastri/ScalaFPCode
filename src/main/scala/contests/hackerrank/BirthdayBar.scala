package contests.hackerrank

object BirthdayBar {

  def main(args: Array[String]): Unit = {
    import scala.io.StdIn._
    readLine
    val l = readLine.split(" ").map(_.toInt).toList
    val Array(r, s) = readLine.split(" ").map(_.toInt)
    println(l.sliding(s).count(_.sum == r))
  }
}
