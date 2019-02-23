import scala.util.Random

def generateRandomList(n:Int): List[Int] = {
  val r = new Random()
  (1 to n).foldLeft(List[Int]())((a,_) => r.nextInt(n) :: a)
}

implicit class CountMap[T](s: List[T]) {
  def countMap: Map[T, Int] = {
    s.foldLeft(Map[T, Int]())((a,b) => a +
      (b -> (a.getOrElse(b, 0) + 1))).withDefaultValue(-1)
  }
}

def countOne(l: List[Int]): List[Int] = {
  println(l.countMap)
  l.countMap.filter(_._2 == 1).keys.toList
}

val l = generateRandomList(100)
l.length
countOne(l).length