val first = Rational(10, 20)
val second = Rational(10, 20)

def distinctString(s: String, accumString: String = ""): String = {
  if (s.length == 0) accumString
  if (s.length == 1) {
    if (!accumString.contains(s)) (accumString + s)
    else (accumString)
  }
  else {
    val head = s.head
    if (!accumString.contains(head)) distinctString(s.tail, accumString + head)
    else distinctString(s.tail, accumString)
  }
}

case class Rational(x: Int, y: Int) {
  def *(y: Rational) = {
    Rational(this.x * y.x, this.y * y.y)
  }

  override def toString: String = {
    s"$x/$y"
  }
}

first * second

object Rational {
  def multiply(x: Rational, y: Rational) = {
    Rational(x.x * y.x, x.y * y.y)
  }
}

distinctString("SASASAB")