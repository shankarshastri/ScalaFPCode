import scala.annotation.tailrec

object Prg1 extends App {


  val t = scala.io.StdIn.readLine.toInt
  val listOfStr = scala.io.StdIn.readLine.split(" ").toList

  @tailrec
  def wordsAramic(s: List[String], presentStr: List[String] = List[String](), count: Int = 0): Int = {
    if (s.length == 0) count
    else {
      val uniqueString = s.head.sorted.distinct
      if (presentStr.contains(uniqueString))
        wordsAramic(s.tail, presentStr, count)
      else wordsAramic(s.tail, presentStr :+ uniqueString, count + 1)
    }
  }

  println(wordsAramic(listOfStr))
}
