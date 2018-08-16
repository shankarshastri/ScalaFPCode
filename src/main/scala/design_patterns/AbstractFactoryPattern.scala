package design_patterns

// CreationalPattern
// AbstractFactoryPattern
// This is used to encapsulate a group of individual factories that have a common theme.
// When used, the developer creates a specific implementation of the abstract factory and uses its methods in the same way as in the factory design pattern to create objects.
// It can be thought of as another layer of abstraction that helps to instantiate classes.

trait Animal {
  def speak: Unit
}

class Lion extends Animal {
  override def speak: Unit = println("Roar")
}

class Dog extends Animal {
  override def speak: Unit = println("Bark")
}

object AbstractFactoryPattern extends App {
  println(new Dog().speak)
  println(new Lion().speak)
}
