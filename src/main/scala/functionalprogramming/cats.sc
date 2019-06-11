import cats.data.Reader
import cats.syntax.apply._

import scala.concurrent.Future

case class User(name: String, age:Int)


def map[A, B](l: List[A], f: A => B): List[B] = {
  l.foldRight(List[B]())((a,b) => f(a) :: b)
}

def filter[A](l: List[A], c: A => Boolean): List[A] = {
  l.foldRight(List.empty[A])((a,b) => if(c(a)) a :: b else b)
}

def sum[A](l: List[A])(implicit nm: Numeric[A]) = {
  l.foldRight(nm.zero)(nm.plus)
}

import cats._
import cats.instances.all._
import cats.syntax.all._
import cats.syntax.traverse._
Semigroupal[List].product(List(1,2,3), List(2,3,4))



trait Uptime[F[_]] {
  def getUptime(hostname: String): F[Int]
}


trait AsyncUptime extends Uptime[Future] {
  override def getUptime(hostname: String): Future[Int] = {
    Future.successful(20)
  }
}

type Id[A] = A
def foldMap[A, B](a: Vector[A])(f: A => B)(implicit m: Monoid[B]): B = {
  a.map(f).combineAll
}

import scala.concurrent.ExecutionContext.Implicits.global
//def parallelFoldMap[A, B : Monoid](values: Vector[A])(func: A => B): Future[B] = {
//  values.grouped(Runtime.getRuntime.availableProcessors()).map(e => Future(func(e))).toList.combineAll
//}


val  k = Reader[Int, Reader[Int, Future[Int]]] (a => Reader[Int, Future[Int]](b => Future.successful(a+b)))


def mul(i: Int)(j: Int) = i*j
def add(i: Int)(j: Int) = i+j





