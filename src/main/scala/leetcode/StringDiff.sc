val ele = List[List[Int]](List(1, 2), List(1, 3), List(2, 4))
val distinctEleList = ele.flatten.sorted.distinct

val l = Array.fill(distinctEleList.last, distinctEleList.last)(false)

ele.foreach(ele => {
  val head = ele.head - 1
  val tail = ele.tail
  ele.tail.foreach(e => l(head)(e - 1) = true)
})


l.map(_.toList)





val l1 = List[Int](1, 3, 1, 5, 3, 4).sorted


//def convertToLimit(l: List[Int], limit: Int, accumList: List[Int] = List[Int](),
//                   accumSum: Int = 0): List[Int] = {
//  l match {
//    case head :: Nil if accumSum + head <= limit => (accumSum + head) :: accumList
//    case head :: Nil if accumSum > 0 => head :: accumSum :: accumList
//    case head :: Nil => head :: accumList
//    case head :: tail if accumSum + head <= limit  && accumSum > 0 =>
//      convertToLimit(tail, limit, accumSum + head :: accumList, 0)
//    case head :: tail if accumSum + head <= limit =>
//      convertToLimit(tail, limit, accumList, accumSum + head)
//    case head :: tail => convertToLimit(tail, limit, accumSum :: accumList, head)
//  }
//}
//
//convertToLimit(l1, 5)

//
//object SolutionC {
//
//  def closestSumPairHelper(l: List[ListMap[Int, Boolean]], sum: Int): List[ListMap[Int, Boolean]] = {
//    val mapCalc = l.zipWithIndex.filter(!_._1.b)
//    val mappedMap = mapCalc.tail
//      .map(e => (mapCalc.head._1.a, e._1.a, mapCalc.head._1.a + e._1.a, e._1.b, e._2))
//      .filter(_._3 <= sum)
//    println(mappedMap)
//    mappedMap match {
//      case _ if mappedMap.isEmpty => l.updated(0, mapCalc.head._1.copy(b = true))
//      case _ =>
//        val calc = mappedMap.max
//        l.updated(0, ListMap(calc._1, true)).updated(calc._5, ListMap(calc._2, true))
//    }
//  }
//
//  //Find Closest Sum Pair
//  def closestSumPair(m: List[ListMap[Int, Boolean]], sum: Int, accumCount: Int = 0): Int = {
//    if (m.filter(!_.b).size == 0) accumCount
//    else {
//      closestSumPair(closestSumPairHelper(m, sum), sum, accumCount + 1)
//    }
//  }
//
//  case class ListMap[A, B](a: A, b: B)
//
//  def numRescueBoats(people: Array[Int], limit: Int): Int = {
//    closestSumPair(people.toList.map(ListMap(_, false)), limit)
//  }
//}
//
//SolutionC.numRescueBoats(Array(3,2,2,1).sorted, 3)
//
