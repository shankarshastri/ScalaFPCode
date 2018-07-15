val l = "2,1,5,6,2,3".split(",").map(_.toInt).toList

l.sliding(2).toList.map(x => Math.abs(x.head - x.tail.head))


