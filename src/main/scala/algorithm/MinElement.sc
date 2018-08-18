//import scala.util.Random
//


def filter(l: List[Int], op: (Int) => Boolean): List[Int] = {
  l match {
    case head :: Nil if !op(head) => Nil
    case head :: Nil => head :: Nil
    case head :: tail if !op(head) => filter(tail, op)
    case head :: tail  => head :: filter(tail, op)
  }
}

filter(List(1,8,9), _ == 9)



//case class GetMinStack[@specialized(Int, Double) T](cmp: (T, T) => Boolean) {
//  private var minEle: Option[T] = None
//  private var stack: List[T] = List[T]()
//  def push(ele: T): Unit = {
//    minEle {
//      case Some(value: T) if cmp(value, ele) =>
//        minEle = Some(value)
//        stack = v
//      case Some(value: T)  =>
//      case None =>
//         minEle = Some(ele)
//    }
//  }
//}



