//5 3 4
//3 2 1 1 1
//4 3 2
//1 1 4 1


val a = List(3,2,1,1,1)
val b = List(4,3,2)
val c = List(1,1,4,1)

def mapWithCumulSum(l: List[Int]): List[Int] = {
  l.reverse.scanLeft(0)(_ + _).tail
}

mapWithCumulSum(a).intersect(mapWithCumulSum(b)).intersect(mapWithCumulSum(c))

List(1).tail