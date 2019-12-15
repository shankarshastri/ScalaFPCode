
/**
  * (i,j) => (i-1, j-1) + (i +1, j+1), (i-1, j+1), (i +1, j-1), (i-1, j), (i+1, j), (i, j+1), (i, j-1)
  *
  *[0,0,0] [0 0 0] [0 0 1] [0 1 1] [0,0,0]
  * [0,0,1], [0,1,2] , [0,1,2]
  * [0,0,0,1,0] [0,0,1,2,0] , [0,0,1,2,0]
  * [0,1,1] , [1,3,3], [1,3,3]
  */

  List(1,2,2).zip(List(1,2))
val l = List[List[Int]](List(0,0,1), List(1,0,0), List(0,0,1))
(List(List(0,0,0)) ::: l ::: List(List(0,0,0))).sliding(3)
  .toList.map(e => e.reduce((a,b) =>
  (a zip b).map(e1 => e1._1 + e1._2)))
  .map(List(0) ::: _ ::: List(0))
.map(_.sliding(3).toList.map(e => e.sum))



def calc(m: List[List[Int]], n: Int): List[List[Int]] = {
  (List(List.fill(n)(0)) ::: m ::: List(List.fill(n)(0)))
    .sliding(n)
    .map(e1 => e1.reduce((a, b) => (a zip b).map(e1 => e1._1 + e1._2)))
    .map(List(0) ::: _ ::: List(0))
    .map(_.sliding(n).toList.map(_.sum)).toList
}

calc(l, 3)