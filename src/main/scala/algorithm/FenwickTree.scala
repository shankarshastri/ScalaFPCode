/**
  * @author ShankarShastri
  *         Algorithm: FenwickTree
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec

/** Immutable 0-indexed Binary Index Tree (BIT) */
case class BinaryIndexedTree[A](size: Int, cumulatives: Vector[A])(implicit num: Numeric[A]) {
  require(cumulatives.size == size + 1)
  
  /** Return the sum of the values indexed from 0 to index (time: O(log(size))) */
  def sum(until: Int): A = {
    @annotation.tailrec
    def f(n: Int, sofar: A): A =
      if (n == 0)
        sofar
      else
        f(n - (n & -n), num.plus(sofar, cumulatives(n)))
    
    f(math.max(0, math.min(size, until)), num.zero)
  }
  
  def sum(from: Int, until: Int): A = num.minus(sum(until), sum(from))
  
  /** Return the updated BIT (time: O(log(size))) */
  def updated(index: Int, value: A): BinaryIndexedTree[A] = {
    require((0 until size).contains(index))
    
    @annotation.tailrec
    def f(n: Int, diff: A, sofar: Vector[A]): Vector[A] =
      if (size < n)
        sofar
      else
        f(n + (n & -n), diff, sofar.updated(n, num.plus(sofar(n), diff)))
    
    copy(cumulatives = f(index + 1, num.minus(value, get(index)), cumulatives))
  }
  
  def updated(elems: (Int, A)*): BinaryIndexedTree[A] =
    elems.foldLeft(this) { case (b, (i, x)) => b.updated(i, x) }
  
  /** Return the value at the specified index (time: O(log(size))) */
  def get(index: Int): A = sum(index + 1, index)
}

object BinaryIndexedTree {
  def apply[A](size: Int)(implicit num: Numeric[A]): BinaryIndexedTree[A] =
    new BinaryIndexedTree[A](size, Vector.fill(size + 1)(num.zero))
}

object FenwickTree {
  def main(args: Array[String]): Unit = {
    
  }
}
