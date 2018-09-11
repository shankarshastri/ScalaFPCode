import scala.annotation.tailrec

val l = List(4, 5, 2, 5, 4, 3, 1, 3, 4)


def filterByCount[T](l: List[T], count: BigInt): List[T] = {
  @tailrec
  def filterByCountHelper[T](l: List[T], accumList: Map[T, BigInt]): List[T] = {
    l match {
      case Nil => List[T]()
      case head :: Nil =>
        accumList
          .updated(head, accumList.getOrElse(head, BigInt(0)) + 1)
          .filter(e => e._2 >= count)
          .keys
          .toList
      case head :: tail =>
        filterByCountHelper(tail, accumList
          .updated(head, accumList.getOrElse(head, BigInt(0)) + 1))
    }
  }
  filterByCountHelper(l, Map[T, BigInt]().withDefaultValue(0))
}

def orderByIndex[T](l: List[T], filteredList: List[T]): List[T] =
  l.distinct.filter(e => filteredList.exists(_ == e))

orderByIndex(l, filterByCount(l, 2))


//3
//9 2
//4 5 2 5 4 3 1 3 4

object Solution {
  
  import scala.io.StdIn._
  import scala.annotation.tailrec
  
  def loop[T](n:BigInt)(block: => T) = (BigInt(1) to n).foreach(_ => block)
  
  def filterByCount[T](l: List[T], count: BigInt): List[T] = {
    @tailrec
    def filterByCountHelper[T](l: List[T], accumList: Map[T, BigInt]): List[T] = {
      l match {
        case Nil => List[T]()
        case head :: Nil =>
          accumList
            .updated(head, accumList.getOrElse(head, BigInt(0)) + 1)
            .filter(e => e._2 >= count)
            .keys
            .toList
        case head :: tail =>
          filterByCountHelper(tail, accumList
            .updated(head, accumList.getOrElse(head, BigInt(0)) + 1))
      }
    }
    filterByCountHelper(l, Map[T, BigInt]().withDefaultValue(0))
  }
  
  def orderByIndex[T](l: List[T], filteredList: List[T]): List[T] =
    l.distinct.filter(e => filteredList.exists(_ == e))
  
  def main(args: Array[String]) {
    val t = BigInt(readLine)
    loop(t) {
      val Array(_, count) = readLine().split(" ").map(_.toInt)
      val l = readLine().split(" ").map(_.toInt).toList
      println(orderByIndex(l, filterByCount(l, count)))
    }
    }
}