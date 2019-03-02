//11
//VBVNSSTSBGG
//5
//VGS
//NTS
//NGS
//VGS
//VGB



implicit class StringUtil(s: String) {
  def countMap: Map[Char, Int] = {
    s.foldLeft(Map[Char, Int]())((a,b) => a + (b -> (a.getOrElse(b, 0) + 1))).withDefaultValue(-1)
  }
}


val s = "VBVNSSTSBGG"




def op(s: Map[Char, Int], order: String): (Int, Map[Char, Int]) = {
  val res = order.map(e => s.getOrElse(e, 0)).product
  val m = order.foldLeft(s)((a,b) => {
    if(a.getOrElse(b, 0) > 0)
    a + (b -> (a.getOrElse(b, 0) - 1))
    else a
  })
  (res, m)
}

op(op(s.countMap, "VGS")._2, "NTS")

