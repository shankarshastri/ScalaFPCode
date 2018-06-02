package programming

object Prg2 extends App {

  //------o-o--o-----o--
  val str = scala.io.StdIn.readLine
  val _count = str.count(_ == '-')
  val ocount = str.count(_ == 'o')
  if (ocount == 1 || ocount == 0 || _count % ocount == 0 || _count == 0 || _count == ocount) println("YES") else println("NO")
}
