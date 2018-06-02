package programming

import scala.annotation.tailrec
import scala.io.StdIn._

object CF_489_ROW_A {

  def main(args: Array[String]): Unit = {
    readLine
    val str = readLine.toCharArray.toList
    checkRows(str) match {
      case true => println("Yes")
      case false => println("No")
    }
  }

  def checkRows(list: List[Char]): Boolean = {
    @tailrec
    def checkRowsHelper(list: List[Char], initialElement: Char): Boolean = {

      if (list.length == 1) oppositeChar(initialElement) == list.head
      else {
        if (oppositeChar(list.head) == initialElement)
          checkRowsHelper(list.tail, list.head)
        else
          false
      }
    }

    if (list.length == 1 && list.head == '0') false
    else if (list.length == 1 && list.head == '1') true
    else checkRowsHelper(list.tail, list.head)
  }

  def oppositeChar(x: Char): Char = if (x == '1') '0' else '1'
}
