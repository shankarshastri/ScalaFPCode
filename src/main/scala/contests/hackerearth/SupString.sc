import scala.collection.immutable.ListMap

val s = "vondwzpktwtrbkyuxtpycqhkvjuilczitmmplbzgzuxcewwbroztghdbsyjdcknxwzmjcnqchn"
val m = s.foldLeft(Map[Char, Int]())((a,b) => a.updated(b, a.getOrElse(b, 0) + 1))





val indexCountMap = s.zipWithIndex.foldLeft(Map[Char, (Int, Int, Int)]())((a,b) => {
  val value = a.getOrElse(b._1, (0,0,0))
  val startIndex = value._1
  val endIndex = value._2
  val count = value._3 + 1
  
  (startIndex, endIndex) match {
    case (0,0) => a.updated(b._1, (b._2, b._2, count))
    case _ => a.updated(b._1, (startIndex, b._2, count))
  }
})
indexCountMap.map(e => (e._1, (e._2._2 - e._2._1 + 1, e._2._3)))

val r = m.maxBy(_._2)
 s.indexOf(r._1) + r._2 * 2




//TODO toMap Converts Or Changes The Sequence Order
implicit class SortMap[A, B](m: Map[A, B]) {
  def sortByKey(implicit ordering: Ordering[A]): Map[A, B]
  = m.toSeq.sortWith((a, b) => ordering.lt(a._1, b._1)).toMap
  def sortByValue(implicit ordering: Ordering[B]): Map[A, B]
  = m.toSeq.sortWith((a, b) => ordering.gt(a._2, b._2)).toMap
}







//
//
//def supStringLen(s: String): Int = {
//  if(s.distinct == s) {
//    (s.length / 2) + 1
//  } else {
//    val m = s.foldLeft(Map[Char, Int]())((a,b) => a.updated(b, a.getOrElse(b, 0) + 1))
//    val r = m.maxBy(_._2)
//    s.indexOf(r._1) + r._2 * 2
//  }
//}
//
//supStringLen(s)
//
