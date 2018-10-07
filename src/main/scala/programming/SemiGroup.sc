trait SemiGroup[T] extends Any {
  def combine(a: T, b: T): T
  def mayCombine(a: Option[T], b: T): T = a.map(combine(_, b)).getOrElse(b)
  def combineN(a: T, b: BigInt): T = {
    (b > 0) match {
      case true => combine(a,a)
      case _ => combineN(combine(a, a), b-1)
    }
  }
}

object SemiGroup {
  def apply[T](a: T, b: T)(implicit ev: SemiGroup[T]): T = ev.combine(a,b)
}

class SemiGroupList[T] extends SemiGroup[List[T]] {
  override def combine(a: List[T], b: List[T]): List[T] = a ++ b
}

class SemiGroupSeq[T] extends SemiGroup[Seq[T]] {
  override def combine(a: Seq[T], b: Seq[T]): Seq[T] = a ++ b
}

class SemiGroupMap[U, V](implicit ev: SemiGroup[V]) extends SemiGroup[Map[U,V]] {
  override def combine(a: Map[U, V], b: Map[U, V]): Map[U, V] = {
    a.foldLeft(b)((a,b) => {
      a.updated(b._1, ev.mayCombine(a.get(b._1), b._2))
    })
  }
}

class SemiGroupNumber[@specialized (Int, Double, Float, Long) T](implicit numeric: Numeric[T]) extends SemiGroup[T] {
  override def combine(a: T, b: T): T = numeric.plus(a, b)
}

class SemiGroupString extends SemiGroup[String] {
  override def combine(a: String, b: String): String = a + b
}


class SemiGroupOption[T](implicit ev: SemiGroup[T]) extends SemiGroup[Option[T]] {
  override def combine(a: Option[T], b: Option[T]): Option[T] = {
    (a,b) match {
      case (Some(a1), Some(b1)) => Some(ev.combine(a1, b1))
      case (Some(a1), None) => Some(a1)
      case (None, Some(b1)) => Some(b1)
      case _ => None
    }
  }
}

object SemiGroupImplicitTypes {
  implicit def numberSemiGroup[T](implicit numeric: Numeric[T]) = new SemiGroupNumber[T]()
  implicit def listSemiGroup[T] = new SemiGroupList[T]()
  implicit def mapSemiGroup[U,V](implicit ev: SemiGroup[V]) = new SemiGroupMap[U,V]()
  implicit def seqSemiGroup[U] = new SemiGroupSeq[U]()
  implicit def stringSemiGroup = new SemiGroupString()
  implicit def optionSemiGroup[T](implicit ev: SemiGroup[T]) = new SemiGroupOption[T]()
}

import SemiGroupImplicitTypes._
import cats.kernel.Monoid

import scala.annotation.tailrec


SemiGroup[Int](1,2)
SemiGroup[List[Int]](List[Int](1,2,3), List(2,3,5))
SemiGroup[String]("s", "s1")


//Seq[Option[T]] to Option[Seq[T]]


def seqToOption[T](s: Seq[Option[T]]): Option[Seq[T]] = {
  @tailrec
  def seqToOptionHelper(s: Seq[Option[T]], accum: Seq[T] = Seq[T]()): Option[Seq[T]] = {
    s match {
      case Some(head) :: Nil => Option(head +: accum)
      case Some(head) :: tail => seqToOptionHelper(tail, head +: accum)
      case _ => None
    }
  }
  seqToOptionHelper(s)
}

seqToOption(Seq(Some(1), Some(2)))
import cats.implicits._
cats.Semigroup.combine(Map("s" -> "s"), Map("s"->"s1"))
  SemiGroup(Map("s" -> "s"), Map("s"->"s1"))
cats.Semigroup.combine(Option(2), None) == SemiGroup(Option(2), None)

Monoid.empty[String]


Monoid.combineAll(List("1", "2", "2"))

val a = Map(1 -> 2)
val b = Map(1 -> 2, 2 -> 4)

a.foldLeft(b)((a,b) => {
  a.updated(b._1, a.getOrElse(b._1, 0) + b._2)
})


def flatten[T](l: List[List[T]]): List[T] = {
  def flattenHelper(l: List[List[T]], accum: List[T] = List[T]()): List[T] = {
    l match {
      case Nil => accum
      case head :: Nil => accum.combine(head)
      case head :: tail => flattenHelper(tail, accum.combine(head))
    }
  }
  flattenHelper(l)
}

List(1,2,3).flatMap()

List(List(List(2))).flatten == flatten(List(List(List(2))))