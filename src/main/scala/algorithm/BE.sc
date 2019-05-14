import scala.collection.immutable.Stack
import scala.collection.immutable.Queue

def minElementInList(l: List[Int]): Stack[Int] = {
  l.foldLeft(Stack.empty[Int])((a, b) => {
    if(a.isEmpty) a.push(b) else if(a.top < b) a.push(a.top) else a.push(b)
  })
}
minElementInList(List(0, 1,2, 3))



