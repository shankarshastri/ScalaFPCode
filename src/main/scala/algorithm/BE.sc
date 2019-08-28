import scalaz.zio.{UIO, _}

import scala.util.Random
import ZIO._

sealed trait TreeType[+T]
final case object LeafNode extends TreeType[Nothing]
final case class IntNode[T](d: T, l: List[TreeType[T]]) extends TreeType[T]



def constructTree[T](level: Int, nON: Int, rootNode: IntNode[T])(d: () => T, g: (() => T, Boolean) => TreeType[T]): TreeType[T] = {
  def constructTreeHelper(level: Int, nON: Int, t: TreeType[T]): TreeType[T] = {
    t match {
      case LeafNode => t
      case e: IntNode[T] =>
        level match {
          case 1 => e.copy(l = (1 to nON).map(_ => constructTreeHelper(level-1, nON, g(d, false))).toList)
          case _ => e.copy(l = (1 to nON).map(_ => constructTreeHelper(level-1, nON, g(d, true))).toList)
        }
    }
  }
  constructTreeHelper(level, nON, rootNode)
}

println("####")
constructTree(4, 1, IntNode(10, List.empty[TreeType[Int]]))(Random.nextInt, (d, f) => {
  if(f) IntNode(d(), List.empty[TreeType[Int]]) else LeafNode})
println("####")


def constructTree[T](level: Int, nON: Int, rootNode: UIO[TreeType[T]])
                    (d: () => T, g: (() => T, Boolean) => UIO[TreeType[T]]): UIO[TreeType[T]] = {
  def constructTreeHelper(level: Int, nON: Int, t: UIO[TreeType[T]]): UIO[TreeType[T]] = {
    t.flatMap {
      case LeafNode => UIO.succeed(LeafNode)
      case e: IntNode[T] =>
        level match {
          case 1 =>
            ZIO.collectAllPar((1 to nON).par
              .map(_ => constructTreeHelper(level - 1, nON, g(d, false))).toList)
              .map(res12 => e.copy(l = res12))

          case _ =>
            ZIO.collectAllPar((1 to nON).par
              .map(_ => constructTreeHelper(level - 1, nON, g(d, true))).toList)
              .map(res12 => e.copy(l = res12))
        }
    }
  }
  constructTreeHelper(level, nON, rootNode)
}
val runtime = new DefaultRuntime {}
runtime.unsafeRun(constructTree(4, 1, UIO.succeed(IntNode(10, List.empty[TreeType[Int]])))(Random.nextInt, (d, f) => {
  if(f) UIO.succeed(IntNode(d(), List.empty[TreeType[Int]])) else UIO.succeed(LeafNode)}))