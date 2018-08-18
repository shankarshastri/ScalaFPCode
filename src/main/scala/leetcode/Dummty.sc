import scala.annotation.tailrec
import scala.collection.immutable.{HashMap, HashSet}
import scala.util.Random
//import scala.annotation.tailrec
//
//val x = List(-1, 0, 1, 2, -1, -4)
//
//val xList = for {
//  i <- 0 until  x.length
//  j <- 0 until x.length
//  k <- 0 until x.length
//  if(i!=j && i!=k && j!=k) &&(x(i) + x(j) +x(k) == 0)
//} yield (x(i),x(j),x(k))
//
//xList.distinct
//
//
////def generateTriplets(list: List[Int]): List[List[Int]] = {
////
////}
//
//
//@tailrec
//def roomVerifier(listOfList: List[List[Int]], currentRoom: Int = 0,
//                 currentKeySet: Set[Int] = Set[Int](0),
//                 keyNotFoundSet: Set[Int] = Set[Int]()):Boolean = {
//  if(listOfList.length == 0) true
//  else if(listOfList.length == 1) {
//    println(currentRoom)
//    val keyNotFoundNewSet = keyNotFoundSet.filter(!currentKeySet.contains(_))
//    if((listOfList.head.length == 0) ||
//      currentKeySet.contains(currentRoom) && keyNotFoundNewSet.size == 0) true
//    else false
//  } else {
//    listOfList match {
//      case head :: tail if
//      currentKeySet.contains(currentRoom) || head.length == 0 => {
//        val keyNotFoundNewSet = keyNotFoundSet.filter(!currentKeySet.contains(_))
//        roomVerifier(tail, currentRoom + 1, head.toSet ++ currentKeySet, keyNotFoundNewSet)
//      }
//
//      case _ :: tail => {
//        val keyNotFoundNewSet = keyNotFoundSet.filter(!currentKeySet.contains(_))
//        roomVerifier(tail, currentRoom + 1 , currentKeySet, keyNotFoundNewSet + currentRoom)
//      }
//    }
//  }
//}
////[[1,3],[1,4],[2,3,2,4,1],[],[4,3,2]]
////[[1,3],[3,0,1],[2],[0]]
//
//val inputList = List(List(1,3), List(1,4), List(2,3,2,4,1), List(), List(4,3,2))
//
//roomVerifier(inputList)


//[[1,3],[3,0,1],[2],[0]]
//[[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]]

val listOfRooms = List(List(6, 7, 8), List(5, 4, 9), List(), List(8), List(4), List(), List(1, 9, 2, 3),
  List(7), List(6, 5), List(2, 3, 1))

listOfRooms.length






val res = listOfRooms.foldLeft((Set[Int](0), Set[Int](), 0, List[Int]()))((a, b) => {
  if (a._1.contains(a._3) || a._1.size == 0) {
    (a._1 ++ b.toSet, a._2, a._3 + 1, a._3 :: a._4)
  } else {
    (a._1, a._2 ++ b.toSet, a._3 + 1, a._4)
  }
})



val diffList = (0 to listOfRooms.length - 1).toList
  .diff(res._4)


diffList.map(x => {
  res._1.foldLeft(false)((a, b) => a || listOfRooms(x).contains(b))
})




object Solution {
  def isPalindrome(x: Int): Boolean = {
    val xStr = x.toString
    (xStr == xStr.reverse)
  }
}


val list = List.fill(10)(Random.nextInt(1000))


//
//
//




def selectionSort(list:List[Int]) = {
  @tailrec
  def selectionSortHelper(list: List[Int], accumList: List[Int] = List[Int]()):List[Int] = {
    if(list.length == 0) accumList
    else {
      val minValue = list.reduceLeft(Math.min(_, _))
      val minValLen = list.filter(_ == minValue).length
      selectionSortHelper(list.filter(_ != minValue), accumList ::: List.fill(minValLen)(minValue))
    }
  }
  selectionSortHelper(list)
}
selectionSort(list)


/*
  * Divide And Conquer Algo's
 */
def quickSort(list:List[Int]): List[Int] = {
  if(list.length < 2) list
  else {
    val pivotElement = list(list.length/2)
    quickSort(list.filter(_ <= pivotElement))  ::: quickSort(list.filter(_ > pivotElement))
  }
}
quickSort(list)


def filterList(keyEle: Int, func: (Int, Int) => Boolean, list: List[Int]) = {
  list.foldLeft(keyEle, List[Int]())((a,b) => {
    if(func(a._1, b)) (a._1, b :: a._2) else (a._1, a._2)
  })._2.reverse
}

filterList(10 , _ > _ , List[Int](1,2,13))



//Two Sum Unique Problem
val k = List(2, 7, 11, 15)
val sum = 20

val hashSet = HashSet(k:_*)
hashSet.filter(x => {
  hashSet.contains(sum - x)
})

//
//def twoSum(sum:Int, list: List[Int]): (Int, Int) = {
//    val hashSet = HashSet(list:_*)
//    hashSet.filter(x => {
//      hashSet.contains(sum - x)
//    })
//}



List(1, 1, 2, 2, 3, 3, 4, 5).toSet.subsets().toList.map(_.toList).flatten