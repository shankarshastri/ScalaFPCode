/**
  * @author ShankarShastri
  *         Algorithm: NonRepeatingElement
  */

package algorithm

import scala.io.StdIn._
import scala.annotation.tailrec


object NonRepeatingElement {
  
  def nonRepeatingElement[T](l: List[T]): List[T] = {
    l.foldLeft(Map[T, Boolean]().withDefaultValue(false), List[T]())((a,b) => {
      if(!a._1(b)) (a._1.updated(b, true), a._2) else (a._1, b :: a._2)
    })._2
  }
  
  def main(args: Array[String]): Unit = {
    nonRepeatingElement(List[Int](1,2,3,4,4))
  }
}
