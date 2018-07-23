  Vector(1,2,3).:+(2)



trait QueueTrait[T] {
  def ele: Vector[T]
  def head: T
  def enqueue(t: T): Queue[T]
}

class Queue[T](val ele: Vector[T]) extends QueueTrait[T] {
  def head: T = ele.head
  def enqueue(t: T): Queue[T] = Queue(ele.:+(t))
  override def toString = s"Queue(${ele.mkString(",")})"
}

object Queue {
  def apply[T](ele: T*): Queue[T] = new Queue[T](ele.toVector)
  def apply[T](ele: List[T]): Queue[T] = new Queue[T](ele.toVector)
  def apply[T](ele: Vector[T]): Queue[T] = new Queue[T](ele)
}

val q = Queue(1,3,4)
q enqueue 10