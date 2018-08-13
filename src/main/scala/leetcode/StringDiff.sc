val ele = List[List[Int]](List(1,2), List(1,3), List(2,4))
val distinctEleList = ele.flatten.sorted.distinct

val l = Array.fill(distinctEleList.last , distinctEleList.last)(false)

ele.foreach(ele => {
  val head = ele.head - 1
  val tail = ele.tail
  ele.tail.foreach(e => l(head)(e-1) = true)
})


l.map(_.toList)