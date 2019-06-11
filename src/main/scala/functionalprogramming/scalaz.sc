import cats._
import cats.data.{EitherT, Kleisli, OptionT, Reader, State}

import scala.concurrent.Future




List(1, 2, 3, 4) map {(_: Int) * (_:Int)}.curried

case class Animal(name: String, region: String)


val getName = Reader[Animal, String](animal => animal.name)

case class Db(
                usernames: Map[Int, String],
                passwords: Map[String, String])

type DbReader[T] = Reader[Db, T]

def findUsername(userId: Int): DbReader[Option[String]] =
  Reader[Db, Option[String]](db => db.usernames.get(userId))

def checkPassword(
                   username: String,
                   password: String): DbReader[Boolean] =
  Reader[Db, Boolean](db => db.passwords.exists(_ == username))

val s = State[Int, Int]((x) => (x, x))


sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A])
  extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

def branch[A](left: Tree[A], right: Tree[A]): Tree[A] =
  Branch(left, right)

def leaf[A](value: A): Tree[A] =
  Leaf(value)


val k = (userId: Int) => Kleisli[Id, Db, Option[String]](db => db.usernames.get(userId))


type OptionListInt = OptionT[List, Int]
import cats.instances.either._

type ErrorOr[A] = Either[String, A]

type ErrorOrOption[A] = OptionT[ErrorOr, A]

import cats.instances.int._





OptionT[List, Int](List(Some(20)))

EitherT[List, Option, Int](List(Left(Some(20)))).value

val powerLevels = Map(
  "Jazz"      -> 6,
  "Bumblebee" -> 8,
  "Hot Rod"   -> 10
)

type Response[A] = EitherT[Future, String, A]

import scala.concurrent.ExecutionContext.Implicits.global
import cats.instances.future._
import cats.syntax._


def getPowerLevels(autoBot: String): Response[Int] = {
  powerLevels.get(autoBot) match {
    case None => EitherT.left(Future(s"${autoBot} not found"))
    case Some(v) => EitherT.right(Future(v))
  }
}
def canSpecialMove(ally1: String, ally2: String): Response[Boolean] = {
  for {
    a <- getPowerLevels(ally1)
    b <- getPowerLevels(ally2)
  } yield (a + b) > 15
}

trait Semigroupal[F[_]] {
  def product[A, B](fa: F[A], fb: F[B]): F[(A, B)]
}



class SemigroupalFut extends Semigroupal[Future] {
  override def product[A, B](fa: Future[A], fb: Future[B]): Future[(A, B)] = {
    fa.flatMap(a => fb.map((a, _)))
  }
}

object Semigroupal {
  def apply[F[_]](implicit sm: Semigroupal[F]): Semigroupal[F] = sm
}


implicit val smFutObj = new SemigroupalFut



Semigroupal[Future].product(Future("hello"), Future("Hello1"))

//canSpecialMove(ally1, ally2).map(e => if(e == true)
//  s"${ally1} & ${ally2} are ready to roll out" else  s"${ally1} & ${ally2} needs recharge")


import cats.Monad
import cats.syntax.all._


def product[M[_]: Monad, A, B](x: M[A], y: M[B]): M[(A, B)]  = x.flatMap(res1 => y.map((res1, _)))




case class User(name: String, age: Int)

def getName(m: Map[String, String]) = m.get("name").toRight(s"name field doesn't exist")
def parseInt(s: String) =
  Either.catchOnly[NumberFormatException](s.toInt).leftMap(_ => List(s"${s} is not a number"))

def nonBlank(s: String)(data: String) = Right(data).ensure()


def validate(s: String, n: Int) = s.nonEmpty && n > 0



//Future[Either[Option, ]]



type FutEitOpt[A] = EitherT[OptionT[Future, A], A, String]


//trait SemiGroupal[F[_]] {
//  def product[A, B](fa: F[A], fb: F[B])(implicit sm: Semigroupal[F]): F[(A,B)]
//}
//Semi
//
//
//
//trait SemiGroupalOption extends Semigroupal[Option] {
//  override def product[A, B](fa: Option[A], fb: Option[B]): Option[(A, B)] = {
//    if(fa.isEmpty || fb.isEmpty) None else fa.flatMap(a => fb.map(b => (a, b)))
//  }
//}






















