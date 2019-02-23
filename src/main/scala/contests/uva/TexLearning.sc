val s1 = Seq("z", "b", "a", "a", "b")
val s2 = Seq("a")


def binMask(s1: Seq[String], s2: Seq[String]): String = {
  val s1Len = s1.length
  val s2Len = s2.length
  if(s1Len > s2Len) {
    val updatedS2 = Seq.fill[String](s1Len - s2Len)("") ++ s2
    (s1 zip updatedS2).map(e => if(e._1 == e._2) 1 else 0).mkString("")
  } else {
    val updatedS1 = Seq.fill[String](s2Len - s1Len)("") ++ s1
    (updatedS1 zip s2).map(e => if(e._1 == e._2) 1 else 0).mkString("")
  }
}

binMask(s1, s2)