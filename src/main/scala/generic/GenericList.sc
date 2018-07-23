import scala.annotation.tailrec

//val list = "1 2000 2000 2".split(" ").map(_.toInt).toList
//
//
//val k = 2
//val order = list.sorted.takeRight(k)
//
//
//var expected = order.foldLeft((list, 0, List[Int]()))((a,b) => {
//  val searchedIndex = a._1.indexOf(b, a._2)
//  println(searchedIndex)
//  (a._1, searchedIndex+1, searchedIndex :: a._3)
//})._3.reverse
//
//expected
//
//
//
//(0 :: expected ):+ list.length
//
//if(expected.head != 0) expected = 0 :: expected
//else if(expected.last != list.length ) expected = expected :+ list.length
//expected
//
//expected.sliding(2).toList.map(x => x.tail.head - x.head)

val l = List(1,2,3)


@tailrec
def filter[A](l: List[A], accumList: List[A] = List[A]())(cond: (A) => Boolean): List[A] = {
  l match {
    case Nil => accumList.reverse
    case h :: t if cond(h) => filter(t, h :: accumList)(cond)
    case h :: t => filter(t, accumList)(cond)
  }
}


filter(l)(_ >= 1)


@tailrec
def dropWhileTailRec[A](l: List[A])(cond : A => Boolean): List[A] = {
  l match {
    case Nil => l
    case h :: t if cond(h) => dropWhileTailRec(t)(cond)
    case h :: t => l
  }
}

dropWhileTailRec(List(1, 2, 3))(  (x: Int) => x < 2)


import scala.annotation.tailrec


def init[T](list: List[T]): List[T] = {
  list match {
    case h :: t  if t!=Nil => h :: init(list.tail)
    case _ => Nil
  }
}

init(l)




List(1).foldLeft(0)((a,b) => a + b)



def reverseRec[T](list: List[T]):List[T] = {
  list match {
    case h :: t => reverseRec(t) :+ h
    case _ => Nil
  }
}

def tailRecReverse[T](list: List[T]): List[T] = {
  @tailrec
  def reverseHelper[T](list: List[T],
                       accumList: List[T] = List[T]()): List[T] = {
    list match {
      case h :: t if t!=Nil => reverseHelper(t, h :: accumList)
      case h :: Nil => h :: accumList
      case _ => accumList
    }

  }
  reverseHelper(list)
}


@tailrec
def foldLeft[T, B](list: List[T])
               (z: B)
               (op: (B, T) => B): B = {
  list match {
    case head :: Nil => op(z, head)
    case head :: tail => foldLeft(tail)(op(z, head))(op)
    case _ => z
  }
}

def foldRight[T, B](list: List[T])
                (z: B)
                (op: (T, B) => B): B = {
  foldLeft[T, B](reverseRec(list))(z)((B, T) => op(T,B))
}


foldRight(l)(1)((a,b) => a+b)

//Subtyping Length
def lengthSubType[T <: Int](list: List[T]):Int = {
  foldLeft(list)(0)((a,_) => a+1)
}
//Generic List Length
def lengthRecursive[T](l: List[T]): Int = {
  l match {
    case _ :: Nil => 1
    case _ :: t => 1 + lengthRecursive(t)
    case _ => 0
  }
}
def lengthTailRecursive[T](l: List[T]): Int = {
  @tailrec
  def lengthHelper(l: List[T], count: Int=0): Int = {
    l match {
      case _ :: Nil => count
      case _ :: t => lengthHelper(t, count+1)
      case _ => count
    }
  }
  lengthHelper(l)
}
def sum[T](l: List[T])(implicit num: Numeric[T]): T = foldLeft(l)(num.zero)(num.plus)
def product[T](l: List[T])(implicit num: Numeric[T]): T = foldLeft(l)(num.one)(num.times)
def length[T](l: List[T])(implicit num: Numeric[T]):T = foldLeft(l)(num.zero)((a,_) => num.plus(a, num.one))
def reverse[T](l: List[T]): List[T] = foldLeft(l)(List[T]())((a,b) => b :: a)
def append[T](l: List[T], ele: T): List[T] = foldRight(l)(List[T](ele))(_ :: _)
def append[T](l: List[T], ele: List[T]):List[T] = foldRight(l)(ele)(_ :: _)
def concat[T](l: List[List[T]]):List[T] = foldRight(l)(List[T]())(append)
def addNToEachElement[T](l: List[T], n: T)(implicit num: Numeric[T]): List[T] = foldRight(l)(List[T]())((b, a) => (num.plus(b,n)) :: a)
def filter[T](l: List[T])(op: T => Boolean): List[T] = foldRight(l)(List[T]())((b, a) => if(op(b)) b :: a else a)
def map[T1, T2](l: List[T1])(op: T1 => T2):List[T2] = foldRight(l)(List[T2]())((b,a) => op(b) :: a)
def flatMap[T1, T2](l: List[T1])(op: T1 => List[T2]):List[T2] = concat(map(l)(op))
def addPairwise[T](l1: List[T], l2: List[T])(implicit num: Numeric[T]): List[T] = {
  (l1 , l2) match {
    case (h1 :: Nil, h2:: Nil) => num.plus(h1, h2) :: Nil
    case (h1 :: t1, h2 :: t2) if(t1 != Nil && t2!= Nil) => (num.plus(h1, h2)) :: addPairwise(t1,t2)
  }
}
def zipWith[T1, T2, T](l1: List[T1], l2: List[T2])(op: (T1, T2) => T): List[T] = {
  (l1 , l2) match {
    case (h1 :: Nil, h2:: Nil) => op(h1, h2) :: Nil
    case (h1 :: t1, h2 :: t2) if t1 != Nil && t2!= Nil => op(h1, h2) :: zipWith(t1,t2)(op)
  }
}


def grouped[T](l: List[T], size: Int): List[List[T]] = reverse(foldLeft(l)((List[List[T]](), List[T](), 1, 1))((a, b) => {
  if (a._3 == size) {
    (reverse(b :: a._2) :: a._1, List[T](), 0, a._4 + 1)
  }
  else if (a._4 == l.length) {
    (reverse(b :: a._2) :: a._1, b :: a._2, a._3 + 1, a._4 + 1)
  }
  else {
    (a._1, b :: a._2, a._3 + 1, a._4 + 1)
  }
})._1)

@tailrec
def isSorted[T](l: List[T])(op: (T,T) => Boolean): Boolean = {
  l match {
    case h :: h1 :: Nil if(op(h, h1)) => true
    case h :: h1 :: _ if(op(h, h1)) => isSorted(l.tail)(op)
    case _  => false
  }
}


def fillTailRec[T](n: Int, a: T): List[T] = {
  @tailrec
  def fillHelper(n: Int, accumList: List[T] = List[T]()): List[T] = {
    if(n == 0) accumList
    else {
      fillHelper(n-1, a :: accumList)
    }
  }
  fillHelper(n)
}


def fill[T](n: Int, a: T): List[T] = {
  n match {
    case 0 => Nil
    case _ => a :: fill(n -1, a)
  }
}
def tail[T](list: List[T]): List[T] = {
  list match {
    case _ :: t => t
    case _ => Nil
  }
}
def setFirstHead[T](ele: T, list: List[T]):List[T] = ele :: tail(list)

@tailrec
def drop[A](l: List[A], n: Int)(implicit num: Numeric[A]): List[A] = {
  n match {
    case x if x <= 0 || length[A](l) == 0 => l
    case _ => drop(tail(l), n-1)
  }
}

@tailrec
def dropWhile[T](l: List[T])(f: T => Boolean): List[T] = {
  f(l.head) match {
    case true => dropWhile(l.tail)(f)
    case _ => l
  }
}

dropWhile(List(1,100,200,400))(_ < 100)



def foldLeftRec[A,B](as: List[A], z: B)(f:(B, A) => B) :B = {
  as match {
    case h :: Nil => f(z, h)
    case h :: t => f(foldLeftRec(t, z)(f), h)
  }
}


foldLeftRec(List(1,2,3), 100)(_ + _)
foldLeft(List(1,2,3))(100)(_ + _)


  //Examples
fill(3, 10)
fillTailRec(3, 10)
setFirstHead(10, List(1,2,3))
drop(List(1,2,3), 4)
tail(List(1))
isSorted(List(2,1,3))(_ < _)
// Examples
grouped(List(1,2,3), 2)
//def hasSubsequence[T](l: List[T], subList: List[T])
zipWith(List("a", "b", "c"), List("A", "B", "C"))(_ + _)
zipWith(List(1,2,3), List(1,2,3))(_ * _)
addPairwise(List(1,2,3), List(1,2, 3))
map(List(1,2,3))(_ * 2)
filter(List(1,2,3))(_ % 2 == 0)
addNToEachElement(List(1,2,3), 1)
concat(List(List(1,2,3), List(2,1,3)))
append(List(1,2,3), 1)
reverse(List(1,2,3))
length(List(1,2,3))
List(2.0).sum
product(List(2,3,1))
//sum(List(1))(Numeric[Double]())
length[Char](List('1'))
length(List(1,2,3))
reverse(List(1,2))
tailRecReverse(List(1,2))
