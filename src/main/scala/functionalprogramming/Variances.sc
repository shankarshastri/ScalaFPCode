class Noun
class CoVarianceCity[A, +T <: A](a: T) extends Noun {
  def  print = {
    println(a)
  }
}

class InVarianceCity[T](a: T) extends  Noun {
  def print = {
    println(a)
  }
}


class ContraVarianceCity[-T](a: T) extends  Noun {
  def print = {
    println(a)
  }
}


new CoVarianceCity[]()







