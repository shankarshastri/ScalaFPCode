//sealed abstract class Tree[T]{
//  def isLeaf: Boolean
//}
//
//class Leaf[T](node: T) extends Tree {
//  override def isLeaf: Boolean = true
//}
//
//class NonEmptyTree[T](node: T, left: Tree[T], right: Tree[T]) extends Tree {
//  override def isLeaf: Boolean = false
//}
//
//object Tree {
//  def buildBinaryTreeFromList[T](l: List[T]) = {
//
//    def buildHelper(l: List[T], t: Tree[T]) = {
//      l match {
//        case head  :: tail => new NonEmptyTree[T](head, )
//      }
//    }
//  }
//}

val s = "dddcdbba"

implicit class StringUtil(s: String) {
  def countMap: Map[Char, Int] = {
    s.foldLeft(Map[Char, Int]())((a,b) => a + (b -> (a.getOrElse(b, 0) + 1))).withDefaultValue(-1)
  }
}


s.countMap
s.indexOf('h')
(((for {
  i <- s.indices
  if s.countMap(s(i)) == 1
} yield i).toList) :+ -1).head

s.toList

//def traverse(l: List[Char], countMap: Map[Char,Int]) = {
//  l match {
//    case Nil => -1
//    case head :: Nil =>
//      if(countMap.getOrElse(head, -1) == 1)
//
//    case head :: tail =>
//  }
//}

val expectedMap = Map("a" -> 1,
  "b" -> 3, "c" -> 3, "d" -> 2, "e" -> 1, "f" -> 4, "g" -> 2, "h" -> 4,
  "i" -> 1, "j" -> 8, "k" -> 5, "l" -> 1, "m" -> 3, "n" -> 1, "o" -> 1,
  "p" -> 3, "q" -> 10, "r" -> 1, "s" -> 1, "t" -> 1, "u" -> 1, "v" -> 4,
  "w" -> 4, "x" -> 8, "y" -> 4, "z" -> 10)

val currentMap = Map(1 -> Seq("A", "E", "I", "O", "U", "L", "N", "R", "S", "T"),
  2 -> Seq("D", "G"), 3 -> Seq("B", "C", "M", "P"), 4 -> Seq("F", "H", "V", "W", "Y"),
  5 -> Seq("K"), 8 -> Seq("J", "X"), 10 -> Seq("Q", "Z"))

currentMap.groupBy(_._1).map(e => (e._1, e._2.values.toList.flatten)).map(e => (e._1, Seq(e._2)))

currentMap.flatMap(e => e._2.map(a => (a.toLowerCase, e._1))) == expectedMap

45f