trait SemiGroup[T] extends Any {
  def combine(a: T, b: T): T
  
  def mayCombine(a: Option[T], b: T): T = a.map(combine(_, b)).getOrElse(b)
  
  def combineN(a: T, b: BigInt): T = {
    
    def combineNHelper(b: BigInt, res: T): T = {
      (b <= 1) match {
        case true => res
        case _ => combineNHelper(b - 1, combine(a, res))
      }
    }
    combineNHelper(b, a)
  }
}

object SemiGroup {
  def apply[T](implicit ev: SemiGroup[T]): SemiGroup[T] = ev
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

SemiGroup[String].combine("H", "He")
SemiGroup[Option[Int]].combine(Option(2), None)
SemiGroup[Double].combine(10, 20)
SemiGroup[List[Char]].combine(List('1'), List('2'))
SemiGroup[String].combineN("H1", 10).length
