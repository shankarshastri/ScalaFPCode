import scala.annotation.tailrec

val a = Array(1,2,3).foldLeft(Array.empty[Int])((a,b) => a.+:(b))


def max(a: Int, b: Int): Int = if(a > b) a else b
def min(a: Int, b: Int): Int = if(a < b) a else b

def mergeAndReduce[A](a: List[A], b: List[A])(mergeFunc: (A,A) => A)(reduceFunc: (A,A) => A): A = {
  @tailrec
  def mergeHelper(a: List[A], b: List[A], accum: List[A] = List[A]()): List[A] = {
    (a,b) match {
      case (Nil, Nil) => accum
      case (headA :: tailA, headB :: tailB) => mergeHelper(tailA, tailB, mergeFunc(headA, headB) :: accum)
    }
  }
  
  def reduceHelper(a: List[A]): A  = {
    a match {
      case head :: Nil => head
      case head :: tail => reduceFunc(head, reduceHelper(tail))
    }
  }
  reduceHelper(mergeHelper(a,b))
}

mergeAndReduce(List(1,3,4), List(1,2,3))(max)(min)


def mergeAndReduceInt(a: List[Int], b: List[Int])(mergeFunc: (Int, Int) => Int)(reduceFunc: (Int,Int) => Int): Int = {
  @tailrec
  def mergeHelper(a: List[Int], b: List[Int], accum: List[Int] = List[Int]()): List[Int] = {
    (a,b) match {
      case (Nil, Nil) => accum
      case (headA :: tailA, headB :: tailB) => mergeHelper(tailA, tailB, mergeFunc(headA, headB) :: accum)
    }
  }
  
  def reduceHelper(a: List[Int]): Int  = {
    a match {
      case Nil => 0
      case head :: Nil => head
      case head :: tail => reduceFunc(head, reduceHelper(tail))
    }
  }
  reduceHelper(mergeHelper(a,b))
}
mergeAndReduceInt(List(1,3,4), List(1,2,3))(_.min(_))(_.max(_))

def add(a: Int, b:Int) = a + b

val add1 = add(1, _)
val addCopy =  add(_, _)
val add2 = add(_, 2)
add1(1)
add2(2)

object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    factors.flatMap(f => Range(0, limit, f)).toSet.sum
  }
}