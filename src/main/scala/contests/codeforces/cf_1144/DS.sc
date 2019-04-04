//8
//fced
//xyz
//r
//dabcef
//az
//aa
//bad
//babc



val alphaStr = "abcdefghijklmnopqrstuvwxyz"
val s = "fced".sorted

s.headOption match {
  case None => println("No")
  case Some(l) =>
    alphaStr.indexOf(l) match {
      case e if (s.diff(alphaStr.substring(e, e + s.length)).length == 0 && e != -1) => println("Yes")
      case _ => println("No")
    }
}