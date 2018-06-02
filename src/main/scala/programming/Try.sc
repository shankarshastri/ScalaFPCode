

val l = List(24, 21, 14, 10)


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

createListGroup(l).map(x => x._2 - x._1)
  .map(Math.abs(_))
  .distinct
  .sortWith(_ > _)
  .take(2)
  .reduce((a, b) => a - b)





def checkWhetherAP(list: List[Int]) = {
  createListGroup(list).map(x => x._2 - x._1).distinct.length == 1
}