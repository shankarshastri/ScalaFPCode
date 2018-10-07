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





































