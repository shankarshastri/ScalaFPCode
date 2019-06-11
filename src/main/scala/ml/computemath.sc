val add = (a: Int, b: Int) => a + b
val sub = (a: Int, b: Int) => a - b
val mul = (a: Int, b: Int) => a * b
val div = (a: Int, b: Int) => {
  if(b == 0) 0
  else a / b
}

def computeSymbol(a: Int, b: Int, c: Int, res: Int): List[String] = {
  val l = List(add, sub, mul, div)
  val mapOfOp = Map[(Int, Int) => Int, Char]((add -> '+'), (sub -> '-'), (mul -> '*'), (div -> '/'))
  val bodmasOfOp = Map[(Int, Int) => Int, Int]((add -> 3), (sub -> 4), (mul -> 2), (div -> 1))
  val resOps = l.map(a => l.map(b => (a,b)))
  resOps.flatMap(e => {
    e.map(e1 => {

      if(bodmasOfOp(e1._1) < bodmasOfOp(e1._2)){
        (e1, e1._2(e1._1(a,b),c))
      } else {
        (e1, e1._1(a,e1._2(b, c)))
      }

    }).filter(res1 => res1._2 == res).map(res2 => (mapOfOp(res2._1._1), mapOfOp(res2._1._2)))
  }).map(s => s"$a ${s._1} $b ${s._2} $c")
}



computeSymbol(2,0,6, 0)



/**

  a () b () c = res
  +, -, *, /
++, +-, -+, --,
  */