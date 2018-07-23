package algorithm
/**
  * @author ShankarShastri
  *         Algorithm: MergeOverlappingIntervals (https://www.geeksforgeeks.org/merging-intervals/)
  */
object MergeOverlappingInterval extends App {
  import scala.annotation.tailrec

  val l = List((6,8), (1,9), (2,4), (5,7))


  def getMergedInterval(l: List[(Int, Int)]): List[(Int, Int)] = {
    @tailrec
    def getMergedIntervalHelper(start: (Int,Int) , l: List[(Int, Int)],
                                accumList: List[(Int,Int)] = List[(Int, Int)]())
    : List[(Int,Int)] = {
      l match {
        case h :: Nil if h._1 <= start._2 =>
          (start._1, start._2 max h._2) :: accumList
        case h :: Nil =>  start :: h :: accumList
        case h :: t if h._1 <= start._2  =>
          getMergedIntervalHelper((start._1, start._2 max h._2), t)
        case h :: t =>
          getMergedIntervalHelper(h, t, start :: accumList)
      }
    }
    val sortedList = l.sorted
    getMergedIntervalHelper(sortedList.head, sortedList.tail).sorted
  }

  println(getMergedInterval(l))
}