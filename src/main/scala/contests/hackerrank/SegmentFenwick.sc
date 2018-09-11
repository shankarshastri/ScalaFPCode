object SegmentTree {
  def buildSegmentTree[T](l: List[T]): SegmentTreeList[T] = {
    l.length match {
      case 1 => SegmentTreeList(l, None, None)
      case n =>
        val splitLength = if (n % 2 == 0) n/2 else n/2 + 1
        val splitList = l.splitAt(splitLength)
        SegmentTreeList(l, Option(buildSegmentTree(splitList._1)),
          Option(buildSegmentTree(splitList._2)))
    }
  }
  
  def buildSegmentTreeSum[T](l: List[T])(implicit numeric: Numeric[T]): SegmentTree[T] = {
    l.length match {
      case 1 => SegmentTree(l.head, None, None)
      case n =>
        val splitLength = if (n % 2 == 0) n/2 else n/2 + 1
        val splitList = l.splitAt(splitLength)
        SegmentTree(l.sum, Option(buildSegmentTreeSum(splitList._1)),
          Option(buildSegmentTreeSum(splitList._2)))
    }
    
    
//    def querySegmentTree[T](s: SegmentTree[T], l: Int, r: Int) = {
//      s m
//    }
  }
  
  
//  def buildSegmentTreeSumFromChild[T](l: List[T])(implicit numeric: Numeric[T]): SegmentTree[T] = {
//    l.
//  }
}







case class SegmentTree[T](data: T, l: Option[SegmentTree[T]], r: Option[SegmentTree[T]])
case class SegmentTreeList[T](data: List[T], l: Option[SegmentTreeList[T]], r: Option[SegmentTreeList[T]])




SegmentTree.buildSegmentTree(List[Int](1,3,-2, 8,-7))
SegmentTree.buildSegmentTreeSum(List[Int](1,3,-2, 8,-7))


