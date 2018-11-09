object Equal {
  
  def eq[T](a: T, b: T): Boolean =  {
    a.equals(b)
  }
  def ===[T](a: T, b: T): Boolean = eq(a,b)
}


//Equal.===[Int]("s", 1)



trait F[+A]
//Covariance means that the type F[B] is a subtype of the type F[A]
// if B is a subtype of A

trait Shape
class Circle(radius: Double) extends Shape


val shape: Shape = new Circle(10)


trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]) =
    monoid
}

case class MonoidBoolean() extends Monoid[Boolean] {
  override def empty: Boolean = false
  override def combine(x: Boolean, y: Boolean): Boolean = x || y
}

case class MonoidInt() extends Monoid[Int] {
  override def empty: Int = 0
  override def combine(x: Int, y: Int): Int = x + y
}

case class MonoidDouble() extends Monoid[Double] {
  override def empty: Double = 0
  override def combine(x: Double, y: Double): Double = x + y
}

case class MonoidLong() extends Monoid[Long] {
  override def empty: Long = 0
  override def combine(x: Long, y: Long): Long = x + y
}

case class MonoidOption[T](implicit m: Monoid[T]) extends Monoid[Option[T]] {
  override def empty: Option[T] = None
  override def combine(x: Option[T], y: Option[T]): Option[T] = x match {
    case Some(xVal) =>
      y match {
        case Some(yVal) => Some(m.combine(xVal, yVal))
        case _ => Some(xVal)
      }
    case _ => y
    }
}

object MonoidImplicitClasses {
 implicit def monoidBoolean = MonoidBoolean()
}

def add(items: List[Int])(implicit m: Monoid[Int]): Int = {
  def addHelper(items: List[Int], res: Int = 0): Int = {
    items match {
      case Nil => res
      case head :: Nil => m.combine(head, res)
      case head :: tail => addHelper(tail, m.combine(head, res))
    }
  }
  addHelper(items)
}

def addOption(items: List[Option[Int]])(implicit m: Monoid[Option[Int]]): Option[Int] = {
  def addHelper(items: List[Option[Int]], res: Option[Int] = None): Option[Int] = {
    items match {
      case Nil => res
      case head :: Nil => m.combine(head, res)
      case head :: tail => addHelper(tail, m.combine(head, res))
    }
  }
  addHelper(items)
}
implicit def monoidInt = MonoidInt()
implicit def monoidOption = MonoidOption()
add(List[Int](1,2,3))
addOption(List[Option[Int]](Option(1), Option(10)))




case class Record(ID: String, Count: Double)
List(Record("1", 12), Record("1", 13), Record("2", 13))
  .groupBy(_.ID)
  .map(e => Record(e._1, e._2.map(e=> e.Count).sum))