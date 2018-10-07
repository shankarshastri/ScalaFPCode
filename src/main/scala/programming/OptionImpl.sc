import scala.annotation.tailrec
import scala.collection.SortedMap
import scala.concurrent.Future
import scala.util.Try

def map2[A,B,C](a: Option[A], b: Option[B])(f: (A,B) => C): Option[C] = {
  (a,b) match {
    case (Some(aVal), Some(bVal)) => Option(f(aVal, bVal))
    case _ => None
  }
}

def sequence[A](a: List[Option[A]]): Option[List[A]] = {
  @tailrec
  def seqHelper(a: List[Option[A]], accumL: List[A] = List.empty): Option[List[A]] = {
    a match {
      case head :: Nil if head.isDefined => Some(head.get :: accumL)
      case _ :: Nil => None
      case head :: tail if head.isDefined => seqHelper(tail, head.get :: accumL)
      case _ :: _ => None
    }
  }
  seqHelper(a)
}
//
//import scala.concurrent.ExecutionContext.Implicits.global
//def sequenceFutureWithResults[T](futList: List[Future[T]]): List[T] ={
//
//  futList.tail.foldLeft(Future.successful())((a,b) => {
//
//  })
//}
//
//sequence(List(Some(100), Some(200)))

//sealed class Either[+A,+B]
//case class Left[A](a: A) extends Either[A, Nothing]
//case class Right[B](b: B) extends Either[Nothing, B]
//
//
//
//def f1(x: Int): Either[Int, Double] = {
//  x match {
//    case x if x == 0 => Left(10)
//    case _ => Right(20.000)
//  }
//}

def toList[A](s: Stream[A]): List[A] = {
  s.isEmpty match {
    case true => Nil
    case _ => s.head :: toList(s.tail)
  }
}



//def take[A](n: Int, s: Stream[A]) = {
//  def takeHelper(s: Stream[A]) = {
//
//  }
//}

toList(Stream('a', 'b'))


val a1 = Stream('a', 'b')
a1.isEmpty
a1
Stream(1,2,3).take(2).toList
//
//
//def headOption[A](s: Stream[A]) = {
// s.foldRight()((a,b) => a match {
//   case
// })
//}




// 0,1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,99,101,111,121,131,141,151,
// 161,171,181,191,202,212,222,232,242,252,262,272,282,292,303
// 1001, 1111, 1221, 1331, 1441, 1551,

// 0 * Math.pow(
//def palindromeLessThanN(n: Long): List[Long] = {
//  val l = List(0,1,2,3,4,5,6,7,8,9)
//  for {
//    i <- 0 until n
//    if
//  }
//}
//

SortedMap[String, (Double, Double)](("h1",(1,3)), ("h2",(1,3)), ("a",(1,3)))
val l = List[Int](1,2,3,4)
def cmpPrevElement[T](l: List[T]): List[(T,T)] = {
  (l.indices).sliding(2).toList.map(e => (l(e.head), l(e.tail.head)))
}



case class Validation(sql: Option[SqlDataSource])
case class SqlDataSource(dfh: Option[DataFrameHolder])
case class DataFrameHolder(sql: Option[String])
val expVal = Validation(Option(SqlDataSource(Option(DataFrameHolder(sql = Option("Hello, World!"))))))
val exception = (s: String) => new IllegalStateException(s"Missing $s")

def optionToEither[T](s: Option[T], ex: Exception): Either[T, Exception] = {
  s match {
    case Some(res) => Left(res)
    case _ => throw ex
  }
}

//optionToEither(None, ex = exception("H"))


def constantStream[A](a: A): Stream[A] = {
  Stream.cons(a, constantStream(a))
}

case class InvalidPasswordException(msg: String, cause: Throwable = null) extends Exception
//(1,1,2,3,5)

case class O() {
  case class N()
}

import scala.util.Random
trait RandomS {
  val r =  new Random()
}



println(r.nextInt())
println(Random.nextInt())