package contests.codeforces.cf_481

object CF_481_4 extends App {

  val numOfElements = scala.io.StdIn.readLine.toInt
  val l = scala.io.StdIn.readLine.split(" ").map(_.toInt).toList
  val listL = createListGroup(l).map(x => x._2 - x._1)
    .map(Math.abs(_))
    .distinct
    .sortWith(_ > _)
    .take(2)
    .reduce((a, b) => a - b)

  def createListGroup[T](
                          list: List[T],
                          accumList: List[(T, T)] = List[(T, T)]()): List[(T, T)] = {
    list match {
      case head :: tail if tail != Nil =>
        createListGroup(tail, accumList :+ (head, tail.head))
      case _ :: tail if tail == Nil => accumList
      case Nil => accumList
    }
  }

  if (listL > l.length) println("-1")
  else println(listL)
}
