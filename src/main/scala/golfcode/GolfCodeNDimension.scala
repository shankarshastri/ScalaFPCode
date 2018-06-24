package golfcode

//# [Scala], 93 bytes
//
//<!-- language-all: lang-scala -->
//
//def f(n: Int)=s"[${(1 to n).map(_=>"["+(1 to n).map(_=>n).mkString(",")+"]").mkString(",")}]"
//
//[Try it online!][TIO-jiqt8nlp]
//
//[Scala]: http://www.scala-lang.org/
//[TIO-jiqt8nlp]: https://tio.run/##K05OzEn8n5@UlZpcolChkFpRkpqXUqzgWFCgUP0/JTVNIU0jz0rBM69E07ZYKVqlWsNQoSRfIU9TLzexQCPe1k4pWkkbXQzEyg4uKcrMS9dQ0lHS1FaKVUITqo1V@m9dAOSW5ORppGkYGWhq1v7/DwA "Scala – Try It Online"
object x {
//  def f(n: Int)=s"[${(1 to n).map(_=>"["+(1 to n).map(_=>n).mkString(",")+"]").mkString(",")}]"

  def f(n:Int)=s"[${Stream.fill(n)(s"[${Stream.fill(n)(n).mkString(",")}]").mkString(",")}]"

  def main(args: Array[String]): Unit = {
    println(f(10))
  }
}