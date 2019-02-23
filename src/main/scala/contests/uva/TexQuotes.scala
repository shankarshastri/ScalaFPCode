/**
  * @author ShankarShastri
  *         Algorithm: uva.TexQuotes
  */

package contests.uva

import scala.io.StdIn._
import scala.annotation.tailrec

object codeOpsTexQuotes {
  def readLineToList(str: String = readLine) = str.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt).toList
  
  def loop[T](n: Int)(block: => T) = (1 to n).foreach(_ => block)
  
  def loopWithRes[T](n: Int)(block: => T) = (1 to n).map(_ => block).toList
}

object TexQuotes {
  
  def strToTexQuotes(s: String): String = {
    s.zipWithIndex.foldLeft(List[(Char, Int)]())((a,b) => {
      if(b._1 == '"') b :: a
      else a
    }).foldLeft((false, s.reverse))((a,b) => {
      if(b._2 == s.length - 2) (false, a._2.replaceFirst("\"", "''"))
      else if(a._1) (false, a._2.replaceFirst("\"", "''"))
      else (true, a._2.replaceFirst("\"", "``"))
    })._2.reverse
  }
  
  def main(args: Array[String]): Unit = {
    val s = """To `C' or not to `C', that is The Question!"
              |""".stripMargin
    strToTexQuotes(s)
  }
}
