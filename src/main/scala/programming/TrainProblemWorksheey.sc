
val x = DirectedGraph[Char]()
val directedGraphInt = DirectedGraph[Int]()


createListGroup(List(1, 2, 3))

'1'.toInt

def createListGroup[T](list: List[T], accumList: List[(T, T)] = List[(T, T)]()): List[(T, T)] = {
  list match {
    case head :: tail if tail != Nil => createListGroup(tail, accumList :+ (head, tail.head))
    case _ :: tail if tail == Nil => accumList
    case Nil => accumList
  }
}


//
//
//implicit class GraphList[T](element: T) {
//  def ~>[T](element: T) = println(this.toString);element
//}
//1 ~> 2 ~> 3


//x.addRoute('0', '1', 10)
//x.addRoute('0', '2', 10)
//x.addRoute('1', '2', 100)
//x.addRoute('2', '0', 100)
//x.addRoute('2', '3', 100)
//x.addRoute('3', '3', 100)
//
//
//x.distanceBetweenNodes(x.adjacencyList, '3', '3')
//x.DFS()('2')
//x.distance(x.adjacencyList, List('0', '1', '2', '2'))

//
//5 4
//1 2
//3 4
//5 4
//3 5

case class DirectedGraph[T]() {
  type graphNode = List[(T, Int)]
  type graph = Map[T, graphNode]

  var adjacencyList = Map[T, List[(T, Int)]]()

  def addRoute(src: T, dest: T, distance: Int = 0): Unit = {
    adjacencyList = immutableAddRoute(src, dest, distance)
  }

  def immutableAddRoute(src: T, dest: T, distance: Int = 0): graph = {
    adjacencyList.updated(src, adjacencyList.getOrElse(src, List[(T, Int)]()) :+ (dest, distance))
  }

  def DFS(graph: graph = adjacencyList, visited: Map[T, Boolean] = Map[T, Boolean]())(startNode: T): Map[T, Boolean] = {
    visited.contains(startNode) match {
      case false => {
        graph.getOrElse(startNode, List[(T, Int)]()).foldLeft(visited.updated(startNode, true))((a, b) => DFS(graph, a)(b._1))
      }
      case _ => visited
    }
  }

  def distance(graph: graph, nodes: List[T]) = {
    createListGroup(nodes).map(x => distanceBetweenNodes(graph, x._1, x._2)).sum
  }

  def distanceBetweenNodes(graph: graph, src: T, dest: T) = {
    graph.getOrElse(src, List[(T, Int)]()).toMap.getOrElse(dest, 0)
  }

  def checkConnectedComponent(graph: graph = adjacencyList, visited: Map[T, Boolean] = Map[T, Boolean]().withDefaultValue(false))
                             (nodes: List[T]) = {
    nodes.foldLeft(visited)((a, b) => {
      if (visited(b) == false) a ++ DFS(graph, visited)(b)
      else a
    })
  }
}

directedGraphInt.addRoute(1, 2)
directedGraphInt.addRoute(3, 4)
directedGraphInt.addRoute(5, 4)
directedGraphInt.addRoute(3, 5)

directedGraphInt.checkConnectedComponent(directedGraphInt.adjacencyList)(List[Int](1, 2, 3, 4, 5))

