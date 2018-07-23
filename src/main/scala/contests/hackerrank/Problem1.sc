val l = "-3,-2,-1,5,6,7,9,11,12,13,15,16".split(",").map(_.toInt).toList



//
//
//def functionalArrayCompact(l: List[Int], rangeLength: Int): String = {
//  var str = ""
//  def arrayCompactHelper(l: List[Int], k: Int, formedString: String, accumResult: String): String = {
//    l match {
//      case h1 :: h2 :: t if h2-h1 == 1 =>
//        arrayCompactHelper(t, k+2, s"${h1},${h2},", accumResult)
//      case h :: t if k > rangeLength && formedString!="" => arrayCompactHelper(t, 0, "", accumResult + formedString)
//    }
//  }
//
//}




def solution(array: Array[Int]): String = {
  val l = array.toList
  var i=0
  val sb = new StringBuilder()
  while(i<l.length) {
    val a = l(i)
    var k = 0
    var str = ""
    while(i+1< l.length && l(i+1) - l(i) == 1) {
      str = str +s"${l(i)},${l(i+1)},"
      k+=1
      i+=1
    }
    if(a != l(i) && k >1) sb.append(s"${a}-${l(i)},")
    else if(k > 0) sb.append(s"${str}")
    else sb.append(s"${a},")
    i+=1
    k=0
  }
  sb.toString().substring(0, sb.length - 1)
}

solution(l.toArray)

val regexPlay = """(\d{3})""".r
