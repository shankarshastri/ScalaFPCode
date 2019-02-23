List(1,2,3)



def split[T](l: List[T], k: Int) = {
  require(k > 0)
  def splitHelper[T](l: List[T],
                     accum: List[T] = List[T](), k: Int): List[T] = {
    k match {
      case 0 =>  l ::: accum.reverse
      case _ =>
        splitHelper(l.tail, l.head :: accum , k - 1)
    }
  }
  splitHelper(l, k = k)
}

split(List(12, 10, 5, 6, 52, 36), 2)


def sortZeroOneTwo(l: List[Int]) = {
  val m = l.foldLeft(Map[Int, Int]())((a,b) => {
    a.updated(b, a.getOrElse(b, 0)+1)
  })
  List.fill(m.getOrElse(0, 0))(0) ::: List.fill(m.getOrElse(1, 0))(1) ::: List.fill(m.getOrElse(2, 0))(2)
}

sortZeroOneTwo(List(1,0,0,1,2))



