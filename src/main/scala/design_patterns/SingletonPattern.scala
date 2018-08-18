package design_patterns


// The singleton design pattern
// This design pattern restricts the creation of a specific class to just one object.
// If more than one class in the application tries to use such an instance, then this same instance is returned for everyone.
// This is another design pattern that can be easily achieved with the use of basic Scala features.

class SingletonPattern private ()

object SingletonPattern {
  private lazy val singletonObj = new SingletonPattern
  def apply(): SingletonPattern = singletonObj
}

object SingletonPatternApp extends App {
  println(SingletonPattern())
}
