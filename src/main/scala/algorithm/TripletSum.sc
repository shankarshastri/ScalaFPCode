//Increasing Triplet Subsequence
//
//val list = List(4, 1, 2, 3, 4, 5)
//
//val res = for {
//  i <- 1 until list.length - 1
//} yield {
//
//}
//res.reduce(_ || _)
//
//
//
//def increasingTripletSeq(list: List[Int]) = {
//  if(list.length <= 2) false
//  val res = for {
//    i <- 1 until list.length - 1
//  } yield {
//    if((list(i-1) < list(i)) && (list(i) < list(i+1))) true
//    else false
//  }
//  res.reduce(_ || _)
//}
//
//

//val list = List(5,4,3,2,1)
//val firstIter = list.splitAt(list.indexOf(list.min))._2.filter(_ > list.min)
//if(firstIter.length != 0) {
//
//} else {
//  0
//}
//
//
//
//
//def increasingTripletSeq(list: List[Int]) = {
//  if(list.length <= 2) false else {
//    val firstIter = list.splitAt(list.indexOf(list.min))._2.filter(_ > list.min)
//    if (firstIter.length != 0) {
//      val res =
//        firstIter.splitAt(firstIter.indexOf(firstIter.min))._2.filter(_ > firstIter.min)
//      if(res.length > 0) true
//      else false
//    } else {
//      false
//    }
//  }
//}


object Solution {


  def increasingTripletSeq(list: List[Int]) = {
    if(list.length <= 2) false else {
      val firstIter =
        list.splitAt(list.indexOf(list.min))
      val firstIterRes = firstIter._1.filter(_ > list.min) ::: firstIter._2.filter(_ > list.min)
      if (firstIterRes.length != 0) {
        val res =
          firstIterRes.splitAt(firstIterRes.indexOf(firstIterRes.min))._2.filter(_ > firstIterRes.min)
        if(res.length > 0) true
        else false
      } else {
        false
      }
    }
  }

  def increasingTriplet(nums: Array[Int]): Boolean = {
    increasingTripletSeq(nums.toList)
  }
}



def increasingTriplet



val list = List(2,1,5,0,3)


for {
  i <- 1 to list.length - 1
} yield list.splitAt(i)._2.dropWhile(_ > list(i))