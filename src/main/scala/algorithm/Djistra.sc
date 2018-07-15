import scala.annotation.tailrec
import scala.util.Random

Double.PositiveInfinity




  val graph = Array.ofDim[Int](4,4)
val gL = for {
  i <- 0 to graph.length - 1
  j <- 0 to graph.length - 1
} yield {
  if(i == j)
  graph(i)(j) = 0
  else graph(i)(j) = Random.nextInt(100)
  graph(i)(j)
}

for {
  i <- 0 to graph.length -1
} yield  graph(i).toList.filter(_ != 0).min

val nmem = Map( '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
val charCode: Map[Char, Char] = for ((digit, str) <- nmem; ltr <- str)
  yield {

    println(ltr -> digit)
    ltr -> digit
  }

def flatten(ls: List[Any]): List[Any] = ls flatMap {
  case i: List[_] => flatten(i)
  case e => List(e)
}
//
//def flattenListComplete(l:List[Any], accumList: List[Int]) = {
//  if(l.length == 1) l.
//}
//

flatten(List(List(List(1,2,3)), List(1,2), List(2)))

def paginate(l: List[Int], pageSize: Int, pageNum: Int) = {
  l.grouped(pageSize).toList.slice(pageNum-1, pageNum)
}

paginate(List(1,2,3,4,5,6), 4, 2)

