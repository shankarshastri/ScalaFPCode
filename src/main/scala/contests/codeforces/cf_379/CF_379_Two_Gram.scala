package contests.codeforces.cf_379

object CF_379_Two_Gram extends App {

  val numOfChar = scala.io.StdIn.readLine
  val string = createListGroup(scala.io.StdIn.readLine.toList)

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

  println(
    string
      .map(x => x._1.toString + x._2.toString)
      .groupBy(identity)
      .mapValues(_.size)
      .toSeq
      .sortWith(_._2 > _._2)
      .head
      ._1)
}
