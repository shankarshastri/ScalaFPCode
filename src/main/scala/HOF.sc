import scala.annotation.tailrec
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success, Try}

val l = List[Int](1,2,3)


def init[T](list: List[T]): List[T] = {
  list match {
    case h :: t  if t!=Nil => h :: init(list.tail)
    case _ => Nil
  }
}

init(l)




List(1).foldLeft(0)((a,b) => a + b)



def reverse[T](list: List[T]):List[T] = {
  list match {
    case h :: t => reverse(t) :+ h
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

reverse(List(1,2))
tailRecReverse(List(1,2))

@tailrec
def foldLeft[T](list: List[T])
               (z: T)
               (op: (T, T) => T): T = {
  list match {
    case head :: tail => foldLeft(tail)(op(z, head))(op)
    case head :: Nil => op(z,head)
    case _ => z
  }
}

def foldRight[T](list: List[T])
               (z: T)
               (op: (T, T) => T): T = {
  foldLeft(reverse(list))(z)(op)
}


foldRight(l)(1)((a,b) => a+b)

import scala.concurrent.ExecutionContext.Implicits.global
//
//Future.traverse(List[Int](1,2,3))(x => Future.successful(x))
//
//Future.never
//Promise
//
////def waitForMultiFuture[T](l: List[Future[T]]): Future[List[T]]


//val x= Future {
//  List(Try(1),
//  Try(throw new Exception("Hello")))
//}.map(x => x.map(Future.fromTry(_)))
//x.transform()


List(Future.fromTry(Success(1)),
  Future.fromTry(Failure(new Exception("Hello")))).map(
  x => for {
    res <- x
  } yield res
)

val prom = Promise[Int]()
val f = Future {
  1
}

f onComplete {
  case Success(i) if i < 5 => prom.failure(new RuntimeException("_ < 5"))
  case Success(x) => prom.success(x)
}

prom.future onComplete {
  case Success(s) => println(s"We cool '$s'")
  case Failure(th) => println(s"All failed, ${th.getMessage}")
}
