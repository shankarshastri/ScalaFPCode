val a = "9 1 2 4".split(" ").map(_.toInt).toList
//
a.sliding(2).foldLeft((0,0))((a,b) => {
  if(b.head > b.tail.head) a.copy(_2 = a._2 + 1)
  else if(b.head < b.tail.head) a.copy(_1 = a._1 + 1)
  else a
})
//
//(1 to 10).foldLeft(10)(_ + _)
//(1 to 10).sliding(100).toList


a.foldLeft()
List(1).lengthCompare(1)