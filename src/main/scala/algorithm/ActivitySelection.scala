/**
  * @author ShankarShastri
  *         Algorithm: Activity Selection
  */

package algorithm

object ActivitySelection {


  def main(args: Array[String]): Unit = {
    val startTimes = List(3, 1, 0, 5, 8, 5)
    val finishTimes = List(4, 2, 6, 7, 9, 9)
    println(activitySelectionProblem(startTimes, finishTimes))
  }

  /**
    * @param start
    * @param end
    * @tparam T
    * @return activities selected in List[(T,T)]
    */
  def activitySelectionProblem[T <: Int](start: List[T], end: List[T]): List[(T, T)] = {
    (start zip end)
      .sortWith((a, b) => a._2 < b._1)
      .foldLeft(List[(T, T)]())((a, b) => {
        if (a.isEmpty) b :: a
        else if (b._1 >= a.head._2) b :: a
        else a
      }).reverse
  }

}
