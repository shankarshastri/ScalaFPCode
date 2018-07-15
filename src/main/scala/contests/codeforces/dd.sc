


def isPowerOfTwo(x: Int): Boolean = {
  (x != 0) && ((x & x - 1) == 0)
}

//List(3,5,4,7,10,12).filter(isPowerOfTwo(_))

List(3, 5, 4, 7, 10, 12).toSet.subsets(2).filter(x => isPowerOfTwo(Math.abs(x.head - x.last))).toSet





val str = "hackerearth"
'h' > 'a'


def compareLexic(s: List[Char], computedString: String): String = {
  println(s.toString)
  println(computedString)
  if(s.length == 2) {
    if(s.head < s.tail.head) computedString + s.tail.head + s.head
    else computedString + s.head + s.tail.head
  } else {
    s match {
      case head :: headPlus1 :: tail =>
        if(head < headPlus1) compareLexic(headPlus1 :: tail, computedString+head)
        else compareLexic(head :: tail, computedString+ headPlus1)
      case _ => computedString
    }
  }
}
compareLexic(str.toCharArray.toList, "")