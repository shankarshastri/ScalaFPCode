trait SemiGroup[T] {
  def combine(a: T, b: T): T
}

object SemiGroup {
  def apply[T](implicit sm: SemiGroup[T]): SemiGroup[T] = sm
}

object SemiGroupImplicit {
  
  
  implicit val intSemiGroup = new SemiGroup[Int] {
    override def combine(a: Int, b: Int): Int = a + b
  }
  
  implicit def listSemiGroup[T] =
    new SemiGroup[List[T]] {
      override def combine(a: List[T], b: List[T]): List[T] = {
        a ::: b
      }
    }
  
  implicit def mapSemiGroup[K, V](implicit v: SemiGroup[V]) = {
    new SemiGroup[Map[K, V]] {
      override def combine(a: Map[K, V], b: Map[K, V]): Map[K, V] = {
        a.foldLeft(b)((l, r) => {
          l.updated(r._1, l.get(r._1).map(v.combine(_, r._2)).getOrElse(r._2))
        })
        }
      }
    }
}


import SemiGroupImplicit._


SemiGroup[Int].combine(100, 200)
SemiGroup[List[Int]].combine(List(1,2), List(2,1))

SemiGroup[Map[Int, Int]].combine(Map(1 -> 2, 2 -> 3), Map(2 -> 10, 3 -> 10))

trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}


object Functor {
  def apply[F[_]](implicit f: Functor[F[_]]): Functor[F[_]] = f
}


object ImplicitFunctor {
  implicit def functorForOption: Functor[Option[_]] = new Functor[Option[_]] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }
}

import ImplicitFunctor._

Functor[Option].map(Option(100))((x: Int) => x * 2)
cats.Functor
