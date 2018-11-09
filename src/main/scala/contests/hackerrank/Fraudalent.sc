val Array(n,k) = "9 5".split(" ").map(_.toInt)
val l = "2 3 4 2 3 6 8 4 5".split(" ").map(_.toInt).toList


implicit class listOps(l: List[Int]) {
  def median:Int = {
    (l.length % 2 == 0) match {
      case true => (l(l.length/2) + l(l.length/2 -1))/2
      case _ => l(l.length/2)
    }
  }
}





l.sliding(5).toList.map(_.sorted.median)