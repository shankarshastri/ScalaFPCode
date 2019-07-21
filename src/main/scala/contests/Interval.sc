// ( 1,  5)    (12, 15)     (42, 44)
//   (70, 72)    (36, 36)     (-4,  2)
//   (43, 69)    (15, 24)


val l =  List((1,5), (12, 15), (42, 44), (70, 72), (36, 36), (-4, 2), (43, 69), (15,24))
//l.sortBy(_._1).sliding(2).foldLeft((0, true))((a,b) => {
//  println(a, b)
//  val a1 = b(0)
//  val a2 = b(1)
//  if(a._2) {
//    if(a2._1 <= a1._2) {
//      (a._1 + 1, false)
//    }
//    else
//      (a._1 + 1, true)
//  } else {
//    (a.copy(_2 = true))
//  }
//})
l.sortBy(_._1).toList

//l.sortBy(_._1).sliding(2).toList


calcInterval(l.sortBy(_._1))

def calcInterval(l: List[(Int, Int)], disjointCount: Int = 0, overlapCount: Int = 0): Int = {
  l match {
    case _ :: Nil => disjointCount + overlapCount + 1
    case h :: h1 :: Nil =>
      if(h1._1 <= h._2)
        disjointCount + overlapCount + 1
      else
        disjointCount + overlapCount + 1
    case h :: h1 :: tail =>
      if(h1._1 <= h._2)
        calcInterval(tail, disjointCount, overlapCount + 1)
      else
        calcInterval(h1 :: tail, disjointCount + 1, overlapCount)
  }
}


