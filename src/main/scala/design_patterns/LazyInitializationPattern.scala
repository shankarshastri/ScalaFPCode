package design_patterns

// The lazy initialization design pattern
// This design pattern is an approach to delay the creation of an object or the evaluation of a value until the first time it is needed.
// It is much more simplified in Scala than it is in an object-oriented language such as Java.


private case class Fruit ()
object Fruit {
  def createFruit = Fruit()
}

object LazyInitializationPattern extends App {
  println(Fruit.createFruit)
}

