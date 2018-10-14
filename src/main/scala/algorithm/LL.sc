import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

val l = List(1,2,3)


def reverseList[T](l: List[T]): List[T] = {
  l match {
    case Nil => Nil
    case head :: tail => reverseList(tail) :+ head
  }
}


def reverseListLoop[T](l: List[T]): List[T] = {
  l.foldLeft(List[T]())((a,b) => b :: a)
}
reverseListLoop(l) == reverseList(l)

def length[T](l: List[T]):Int = {
  l.foldLeft(0)((a,_) => a+1)
}

length(l)

case class Stack[T](e: T*) {
  private var l = e.toList
  def push(a: T): List[T] = {
    l = a :: l
    l
  }
  
  def pop:T = {
    val h = l.last
    l = l.init
    h
  }
  
  override def toString: String = {
    l.mkString(",")
  }
}



def sum(a: List[Int], b: List[Int], res: List[Int]= List[Int]()): List[Int] ={
  (a,b) match {
    case (Nil, Nil) => res
    case (headA :: Nil, headB :: Nil) => (headA + headB :: res).reverse
    case (headA :: tailA, headB :: tailB) => sum(tailA, tailB, (headA + headB) :: res)
  }
}

sum(List(1,2,2), List(1,2,2))


@tailrec
def numberToList(n: Long, res: List[Long] = List[Long]()): List[Long] = {
  (n % 10 == n) match {
    case true => ((n%10) :: res)
    case _ =>
      val nBy10 = n/10
      numberToList(nBy10, n%10 :: res )
  }
}

numberToList(1000)

val n  = 100
val s = Set(3,5)
(1 until n).filter(e => s.exists(s1 => e % s1 == 0)).sum

def sumListWithCarries(a: List[Int], b: List[Int]) = {

}



//[1 2 3]
val k = List(1, 11, 2, 10, 4, 5, 2, 1)

def bitonicSeq(list: List[Int]): List[Int] = {
  val sortedList = list.sorted
  val initList = sortedList.init
  val splitLists = initList.splitAt(initList.length/2)
  splitLists._1 ::: sortedList.last :: splitLists._2
}

bitonicSeq(k)



