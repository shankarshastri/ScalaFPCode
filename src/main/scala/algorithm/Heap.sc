import scala.collection.mutable.ArrayBuffer
//import scala.collection.mutable.ArrayBuffer
//
//
//implicit class ArraySwapUtil[T](a: ArrayBuffer[T]) {
//  def swap(i: Int, j: Int): Unit = {
//    a.isDefinedAt(i) && a.isDefinedAt(j) match {
//      case true =>
//        val r1 = a(i)
//        val r2 = a(j)
//        a.update(i, r2)
//        a.update(j, r1)
//      case _ => ()
//    }
//  }
//}
//
//trait Heap[T] {
//  def insert(a: T)
//  def compare(a: T, b: T)(implicit ordering: Ordering[T]): Boolean
//}
//
//case class HeapNode[T](data: T, leftHeapNode: Option[HeapNode[T]] = None,
//                  rightHeapNode: Option[HeapNode[T]] = None)
//
//
//class MaxHeap[T](r: T)(implicit ordering: Ordering[T]) extends Heap[T] {
//  private val rootHeapNode = HeapNode(r)
//  private var rightMostHeapNode  = HeapNode(r)
//
//
//  override def compare(a: T, b: T)
//                      (implicit ordering: Ordering[T]): Boolean = {
//    ordering.gteq(a, b)
//  }
//
//  override def insert(a: T): Unit =  {
//
//  }
//}


val a = ArrayBuffer(1)
def l = (a.size/2 to 0 by -1).map(_ * 2)
def r = (a.size/2 to 0 by -1).map(e => (e * 2) + 1)
l
r
a.append(2)
l
r
a.append(10)
l
r
