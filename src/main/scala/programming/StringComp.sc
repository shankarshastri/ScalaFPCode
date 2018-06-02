import scala.annotation.tailrec


val str = "SAASSSDSSAS"
val res = str.zipWithIndex.map(x => (x._1, span(str.substring(x._2), x._1))).toList

def span(str: String, ch: Char): Int = {
  @tailrec
  def spanHelper(listChar: List[Char], count: Int = 0): Int = {
    if (listChar.length == 1) {
      if (listChar.head == ch) count + 1
      else count
    } else {
      listChar match {
        case head :: tail if head == ch => spanHelper(tail, count + 1)
        case _ => count
      }
    }
  }

  spanHelper(str.toCharArray.toList)
}



res.foldLeft(List[(Char, Int)]())((a, b) => {
  if (a.isEmpty) b :: a else {

    if (a.head._1 != b._1) b :: a
    else a
  }
}).reverse.map(x => {
  if (x._2 > 1)
    s"${x._1}${x._2}"
  else
    s"${x._1}"
}).mkString


