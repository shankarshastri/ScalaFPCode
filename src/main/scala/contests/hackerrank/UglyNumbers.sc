import scalaz.State

"5, 3, 4, 6".split(", ").map(_.toInt).splitAt(2)


/**
  *
  *
  * B-Tree
  *
  * Input Size-Of The Key Store
  *
  * Partioned DS
  *
  *
  */


/**
  *
  * (1,2, 3, 4, 5)
  *
  */

class BTree(size: Int) {
  implicit val _size = size
  val root = BTreeNode()

  def insert(d: Int, node: BTreeNode) = {
    node.isFull match {
        case true =>
          val size = node.sizeFilled
          if(size % 2 == 0) {
            val f = node.getData.init
            val l = node.getData.last
            val lST = BTreeNode(f)
            node.setData(Vector.empty[BtreeNodeType] :+
              BTreeIntNode(l.data, Some(lST)))
            insert(d, node)
          } else {
            val (l, r) = node.getData.splitAt(node.getData.length/2)

          }
        case false => node.appendData(d)
      }
  }
}

case class BTreeNode(var data: Vector[BtreeNodeType]
                     = Vector.empty[BtreeNodeType])
                    (implicit size: Int) {
  def sizeFilled: Int = data.length
  def isEmpty: Boolean   = data.isEmpty
  def isFull: Boolean = data.size == size
  def getData: Vector[BtreeNodeType] = data
  def appendData(d: Int): BTreeNode = {
    val res = data.zipWithIndex.find(e => e._1.data > d)
      .map(r => data.splitAt(r._2 - 1))
      res.foreach(e =>
        data =  (e._1 :+ Leaf(d)) ++ e._2)
    this
  }
  def setData(data: Vector[BtreeNodeType]): Unit = {
    this.data = data
  }
}


trait BtreeNodeType{
  def data: Int
}
case class Leaf(override val data: Int) extends BtreeNodeType

case class BTreeIntNode(override val data: Int,
                   lST: Option[BTreeNode] = None,
                   rST: Option[BTreeNode] = None) extends  BtreeNodeType
