/**
  * @author ShankarShastri
  *         Algorithm: ReverseQueue
  */

package algorithm.ds

import scala.collection.immutable.Queue

object ReverseQueue {
  def main(args: Array[String]): Unit = {

    var queue = Queue[Int]()
    (1 to 100).foreach(x => queue = queue.enqueue(x))
    println(queue.dequeue)


  }
}
