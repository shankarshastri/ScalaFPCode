package programming

object StringReductions extends App {

  def distinctString(s: String, accumString: String = ""): String = {
    if (s.length == 1) {
      if (!accumString.contains(s)) (accumString + s)
      else {
        accumString
      }
    } else {
      val head = s.head
      if (!accumString.contains(head))
        distinctString(s.tail, accumString + head)
      else distinctString(s.tail, accumString)
    }
  }

  // Using Library Function
  //  scala.io.StdIn.readLine.distinct
  //
  println(distinctString(scala.io.StdIn.readLine))
}
