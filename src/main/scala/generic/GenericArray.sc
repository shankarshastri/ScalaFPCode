
val a = Array[Int](1,2,3)

val l = List[Int](1,2,3)

def findFirst[T](l: Array[T], ele: T)(implicit numeric: Numeric[T]): T = {
  l.headOption match {
    case  Some(v)  if v == ele => numeric.zero
    case Some(_) => numeric.plus(numeric.one ,findFirst(l.tail, ele))
    case None => numeric.minus(numeric.zero, numeric.one)
  }
}



findFirst(a, 1)