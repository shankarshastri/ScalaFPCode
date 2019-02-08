import scala.annotation.tailrec
import scala.concurrent.Future
import scala.util.Try
//
//trait Terminal[T[_]] {
//  def read[U]: T[U]
//  def write[U]: T[U]
//}
//
//
//type Id[U] = U
//
//case class TerminalSync() extends Terminal[Id] {
//  override def read[U]: Id[U] = ???
//  override def write[U]: Id[U] = ???
//}
//
//
//case class TerminalAsync() extends Terminal[Future] {
//  override def read[U]: Future[U] = ???
//  override def write[U]: Future[U] = ???
//}
//
//
//final case class IO[A](interpret: () => A) {
//  def map[B](f: A => B): IO[B] = IO(f(interpret()))
//  def flatMap[B](f: A => IO[B]): IO[B] = {
//    IO(f(interpret()).interpret())
//  }
//}
//
//object IO {
//  def apply[A](a: =>A): IO[A] = new IO(() => a)
//}


// 1, 2, 3, 4, 5
// 1, 2, 3, 4
def biTraverse[T](l: List[T]): List[Either[T,  (T,  T)]] = {
  @tailrec
  def biTraverseHelper(l: List[T],
                       accum: List[Either[T, (T, T)]]
                       = List[Either[T,  (T, T)]]()): List[Either[T,  (T,  T)]] = {
    l.length match {
      case 0 => accum
      case 1 => Left(l.head) :: accum
      case 2 => Right(l.head, l.last) :: accum
      case _ => l match {
        case head +: list :+ last => biTraverseHelper(list, Right(head, last) :: accum)
      }
    }
  }
  biTraverseHelper(l)
}

biTraverse(List(1,8,6,2,5,4,8,3,7))

List(1,2,3).lift


  def loopAndTraverse[T, F[T]](n: BigInt, res: F[T], computation: F[T] => F[T]): F[T] = {
    if(n == 0) res
    else {
      loopAndTraverse(n-1, computation(res), computation)
    }
  }



type Id[T] = T


//loopAndTraverse[Int, Id[Int]]()



def selectionSort(a: List[Int], sortedArray: List[Int] = List[Int]()): List[Int] = {
  a match {
    case Nil => sortedArray.reverse
    case head :: Nil => (head :: sortedArray).reverse
    case l =>
      val min = l.min
      val countOfMin = a.count(_ == min)
      selectionSort(a.filter(_ != min), List.fill(countOfMin)(min) ::: sortedArray)
  }
}


selectionSort(List(3,2,1,4))




def frequentElement(l: List[Int]) = {
  l.foldLeft(Map.empty[Int, Int])((a, b) => a.updated(b, a.getOrElse(b, 0) + 1)).toSeq
    .sortWith((a,b) => a._2 > b._2).head._1
}

frequentElement(List(1,2,4,1,2,2))



def pairs(l: List[Int], i: Int):Int = {
  val map = l.map((_, true)).toMap.withDefaultValue(false)
  l.count(e => map.isDefinedAt(e+i))
}

pairs(List(1 ,5 ,3 ,4 ,2), 2)