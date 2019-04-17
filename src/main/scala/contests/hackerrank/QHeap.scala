/**
  * @author ShankarShastri
  *         Algorithm: QHeap
  */

package contests.hackerrank

import scala.io.StdIn._
import scala.annotation.tailrec

import scala.collection.mutable.ArrayBuffer

object ArrayBufferUtil {
  implicit class ArraySwapUtil(a: ArrayBuffer[Int]) {
    def swap(i: Int, j: Int): Unit = {
      a.isDefinedAt(i) && a.isDefinedAt(j) match {
        case true =>
          val r1 = a(i)
          val r2 = a(j)
          a.update(i, r2)
          a.update(j, r1)
        case _ => ()
      }
    }
  }
}

class QHeap {
  import ArrayBufferUtil._
  
  private val arr = ArrayBuffer[Int]()
  
  final def minHeap(array: ArrayBuffer[Int], i: Int): Unit = {
    val l = (2 * i) + 1
    val r = (2 * i) + 2
    val n = array.size
    var smallest = i
    if(l < n && array(i) > array(l))
      smallest = l
    if(r < n && array(smallest) > array(r))
      smallest = r
    if(smallest != i)
      {
        ArraySwapUtil(array).swap(smallest, i)
      }
  }
  
  def add(e: Int): Unit = {
    arr.append(e)
    (arr.size/2 until 0 by -1).foreach(e => minHeap(arr, e - 1))
  }
  
  
  def delete(e: Int): Unit = {
    arr.remove(arr.indexOf(e))
    (arr.size/2 until 0 by -1).foreach(e => minHeap(arr, e - 1))
  }
  
  def minElement: Int = arr.head
}

object QHeapMain {
  
  def main(args: Array[String]): Unit = {
    val t = readLine.toInt
    val qHeap = new QHeap()
    (1 to t).foreach(_ => {
      val iP  = readLine.split(" ").map(_.toInt)
      iP.head match {
        case 1 => qHeap.add(iP.tail.head)
        case 2 => qHeap.delete(iP.tail.head)
        case 3 => println(qHeap.minElement)
      }
    })
  }
}