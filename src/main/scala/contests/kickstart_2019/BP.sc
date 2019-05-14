//2
//7 5
//ABAACCA
//3 6
//4 4
//2 5
//6 7
//3 7
//3 5
//XYZ
//1 3
//1 3
//1 3
//1 3
//1 3
val pL = "ABAACCA".scanLeft(Map[Char, Int]())((a,b) => {
  a.updated(b, a.getOrElse(b, 0) + 1)
})
pL(6)
pL(2)
pL(6).map(e => e._2 - pL(2).getOrElse(e._1, 0))