val l = List[List[Int]](List(1,2,3,4), List(3,2,1,6), List(4,5,6,7), List(1,2,1,1))

def printAllDiagonals(l: List[List[Int]], m: Int, n: Int, size: Int): Unit = {
  ((m-1 to 0 by -1) zip (n-1 to 0 by -1)).foreach(e => println(e._1,e._2))
  ((m-1 to 0 by -1) zip (n+1 until size by 1)).foreach(e => println(e._1,e._2))
  ((m+1 until size by 1) zip (n+1 until size by 1)).foreach(e => println(e._1,e._2))
  ((m+1 until size by 1) zip (n-1 to 0 by -1)).foreach(e => println(e._1,e._2))
}


printAllDiagonals(l, 2, 2, l.size)
/*
i row index
j column index

    0 1 2
  |-     -|
0 | 1 2 3 |
1 | 4 5 6 |
2 | 7 8 9 |
  |-     -|


(m,n) => (1,1)

diagonal elements are (

(i-1, j-1) , (i-1, j+1), (i+1, j+1),  (i+1, j-1)

*/




val k = 20
val x = 10
val s = List(100, 200, 300).map(e => Math.max((x * e)/100, k)).sum