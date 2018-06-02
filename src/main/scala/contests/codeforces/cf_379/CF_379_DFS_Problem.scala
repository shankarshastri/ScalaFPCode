package contests.codeforces.cf_379

case class DirectedGraph[T]() {
  type graphNode = List[(T, Int)]
  type graph = Map[T, graphNode]

  var adjacencyList = Map[T, List[(T, Int)]]()

  def addRoute(src: T, dest: T, distance: Int): Unit = {
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


  def checkConnectedComponent(graph: graph = adjacencyList, visited: Map[T, Boolean])(nodes: List[T]) = {
    nodes.foldLeft(visited)((a, b) => {
      DFS(graph, visited)(b)
    })
  }
}

object CF_379_DFS_Problem extends App {

  val directedGraph = DirectedGraph[Int]()
}
