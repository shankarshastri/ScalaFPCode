
//import scala.collection.immutable.TreeSet
//
//
//val xList = List(-1, 0, 1, 2, -1, -4)
//
//val res = for {
//  i <- 0 until xList.length -2
//  j <- i + 1 until xList.length -1
//  k <-  j + 1 until xList.length
//  if(xList(i) + xList(j) + xList(k) == 0)
//} yield List(xList(i), xList(j), xList(k))
//
//res.toList.map(x => x.sorted).distinct
//
//

//object Solution {
//  def threeSum(nums: Array[Int]): List[List[Int]] = {
//    val numsList = nums.toList
//    val res = for {
//      i <- 0 until numsList.length -2
//      j <- i + 1 until numsList.length -1
//      k <-  j + 1 until numsList.length
//      if(numsList(i) + numsList(j) + numsList(k) == 0)
//    } yield List(numsList(i), numsList(j), numsList(k))
//    res.toList.map(x => x.sorted).distinct
//  }
//}



val x = Array[Array[Int]](Array[Int](0,0), Array[Int](1,0),Array[Int](2,0))




val elemMap = x.map(ele => (ele.head, ele.tail.head))
for {
  i <- elemMap.indices
  j <- elemMap.indices
  if i!=j
} yield elemMap(i)


