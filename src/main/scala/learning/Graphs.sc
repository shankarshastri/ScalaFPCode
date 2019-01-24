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


10/3

10%3



