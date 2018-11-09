//Exercise 1
trait Printable[T] {
  def format(s: T): String
  def print(s: T): Unit = println(format(s))
}

object PrintableInstances {
  implicit def printableStringL: Printable[String] = new Printable[String] {
    override def format(s: String): String = s
  }
  implicit def printableInt: Printable[Int] = new Printable[Int] {
    override def format(s: Int): String = s.toString
  }
}


object Printable {
  def format[T](s: T)(implicit printable: Printable[T]): String = printable.format(s)
}


import PrintableInstances._
import Printable._
import cats.Functor

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Success, Try}

format(10)
print(10)


final case class Cat(name: String, age: Int, color: String)

implicit val catPrintable = new Printable[Cat] {
  override def format(c: Cat): String = s"${c.name} is a ${c.age} year-old ${c.color} cat"
}

//implicit class catToString(c: Cat) extends Printable[Cat] {
//  override def format(s: Cat): String = s"${c.name} is a ${c.age} year-old ${c.color} cat"
//  def format: String = format(c)
//}


implicit class PrintableSyntax[A](a: A)(implicit p: Printable[A])  {
  def format: String = {
    p.format(a)
  }
  def print: Unit = p.print(a)
}

val c = Cat("S", 1, "s1")
c.format
c.print


val mapOfList = Map(1 -> List(1,2,3), 2 -> List(2,3,4), 3 -> List(4,5,6))
val k = 3
mapOfList.filter(_._2.contains(k)).keys


List(1,2,3).par


trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
  def lift[A,B](f: A => B): F[A] => F[B]
}

val incr = (x:Int) => x+1
//
//def lift[A, B, F[A], G[B]](f: A => B): F[A] => G[B] = {
//
//}
import cats.instances.option._


class OptionFunctor extends Functor[Option] {
  override def map[A,B](fa: Option[A])(f: A => B): Option[B] = fa.map(a => f(a))
  override def lift[A, B](f: A => B): Option[A] => Option[B] = map(_)(f)
}

class UtilFunc[A, F <: () => A] {
  def invokeListOfFunc(l: List[F]) = {
    l.map(_())
  }
}

import scala.concurrent.ExecutionContext.global
class FutureFunctor(implicit ec: ExecutionContext) extends Functor[Future] {
  override def map[A, B](fa: Future[A])(f: A => B): Future[B] = fa.map(f(_))
  override def lift[A, B](f: A => B): Future[A] => Future[B] = map(_)(f)
}

import cats.Contravariant

List(1,2,3).flatMap(_ => List(1,2,3))
def flatMap[A, B](op: Option[A])(f: A => Option[B]): Option[B] = {
  op match {
    case Some(v) => f(v)
    case _ => None
  }
}

def toOption[T](t: Try[T]) = {
  t match {
    case Success(v) => Some(v)
    case _ => None
  }
}

flatMap(Some(100))((x: Int) => Option(x))

import scala.language.higherKinds



trait Monad[T[_]] {
  def pure[A](a: A): T[A]
}

object Monad {
  def apply[T[_]](implicit m: Monad[T[_]]): Monad[T[_]] = m
}


case class MonadList() extends Monad[List] {
  override def pure[A](a: A): List[A] = a :: Nil
}


object MonadImplicit {
  implicit def monadList = MonadList()
}


MonadList().pure(100)

import scala.concurrent.ExecutionContext.Implicits.global
val a = Future(10).flatMap(_ => Future(20)).withFilter(_ > 100)