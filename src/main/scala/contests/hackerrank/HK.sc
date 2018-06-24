import scala.annotation.tailrec
import scala.io.StdIn.readLine


object codeOps {
  def readLineToList(str: String = readLine) = str.split(" ").map(_.toInt).toList
  def loop[T](n:Int)(block: => T) = (1 to n).foreach(_ => block)
  def loopWithRes[T](n:Int)(block: => T) = (1 to n).map(_ => block).toList

  def listOps[T](list: List[T])(baseCaseOp: List[T] => Boolean,
                                genericCaseOp: (List[T], List[T]) => (List[T], List[T]),
                                lastCaseOp: (T, List[T]) => List[T]): List[T] = {
    @tailrec
    def listOpsHelper(list: List[T],
                      accumList:List[T] = List[T]()): List[T] = {
      if(baseCaseOp(list)) {
        lastCaseOp(list.head, accumList)
      }
      else {
        val res = genericCaseOp(list, accumList)
        listOpsHelper(res._1, res._2)
      }
    }
    listOpsHelper(list)
  }

  def streamOps[T](list: Stream[T])(baseCaseOp: Stream[T] => Boolean,
                                    genericCaseOp: (Stream[T], Stream[T]) => (Stream[T], Stream[T]),
                                    lastCaseOp: (T, Stream[T]) => Stream[T]): Stream[T] = {
    @tailrec
    def streamOpsHelper(list: Stream[T],
                        accumList:Stream[T] = Stream[T]()): Stream[T] = {
      if(baseCaseOp(list)) {
        lastCaseOp(list.head, accumList)
      }
      else {
        val res = genericCaseOp(list, accumList)
        streamOpsHelper(res._1, res._2)
      }
    }
    streamOpsHelper(list)
  }
}






import codeOps._
readLineToList("5 6 7")
readLineToList("3 6 10")

def baseCaseOp(list:List[Int]): Boolean = list.length == 1
def genericCaseOp(list:List[Int], accumList: List[Int]): (List[Int], List[Int]) = {
  if (list.head < 3) (list.tail, list.head :: accumList) else (list.tail, accumList)
}
def lastCaseOp(ele: Int, list: List[Int]) = if (list.head < 3) list else ele :: list

listOps[Int](List[Int](1,2,3, 4))(baseCaseOp, genericCaseOp, lastCaseOp)

loopWithRes[Int](10){
  println("Hello")
  2
}
