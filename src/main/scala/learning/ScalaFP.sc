

trait TreeMonad[+A] {
  type F[_]
  val data: F[A]
  val left: Option[TreeMonad[A]]
  val right: Option[TreeMonad[A]]
}

case class SegmentNodeOp[T](data: T,
                            left: Option[SegmentNodeOp[T]],
                            right: Option[SegmentNodeOp[T]]) extends TreeMonad[T] {
  type F[_] = T
}

case class SegmentNode[T](data: List[T] = List[T](),
                          left: Option[SegmentNode[T]] = None,
                          right: Option[SegmentNode[T]] = None) extends TreeMonad[T] {
  type F[_] = List[_]
}

object SegmentNode {
  
  def printSegmentNode[T](s: Option[SegmentNode[T]]): Unit = {
    s match {
      case None => ()
      case Some(s) =>
        println(s.data)
        printSegmentNode(s.left)
        printSegmentNode(s.right)
    }
  }
  
  def constructFromList[T](l: List[T]): Option[SegmentNode[T]] = {
    val len = (l.length % 2 == 0) match {
      case true => l.length/2
      case false => (l.length + 1)/2
    }
    val splitL = l.splitAt(len)
    splitL match {
      case (Nil, Nil) => None
      case (Nil, b: List[T]) => Some(SegmentNode(b, None, None))
      case (a: List[T], Nil) => Some(SegmentNode(a, None, None))
      case (a: List[T], b: List[T]) =>
        Some(SegmentNode(l, constructFromList(a), constructFromList(b)))
    }
  }
  
  def performOperationOnSegmentNode[T](s: SegmentNode[T])(op: List[T] => T): Option[SegmentNodeOp[T]] = {
    s match {
      case e if e == SegmentNode[T]() => None
      case e  => Some(SegmentNodeOp(op(e.data),
        performOperationOnSegmentNode(e.left.getOrElse(SegmentNode()))(op),
        performOperationOnSegmentNode(e.right.getOrElse(SegmentNode()))(op)))
    }
  }
  
  
  def update[T](s: SegmentNode[T], id: Int, value: T): SegmentNode[T] = {
    val lenBy2 = (s.data.length % 2 == 0) match {
      case true => s.data.length/2
      case false => (s.data.length + 1)/2
    }
    (id >= lenBy2) match {
      case true => update(s.copy(s.data.updated(id, value)), id, value)
    }
  }
}


// 1, 3, 4, 5
//1,3  |  4,5
//  1 | 3   || 4 | 5

val n = SegmentNode.constructFromList(List(1,3,5,7,9,11))
SegmentNode.printSegmentNode(n)
def op[T](l: List[T])(implicit n: Numeric[T]) = l.sum
SegmentNode.performOperationOnSegmentNode(n.getOrElse(SegmentNode()))(op)

