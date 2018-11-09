import scala.annotation.tailrec

val mySet = Set("Michigan", "Ohio", 12)


val list = List(3, 2, 0, 1)
val x = List(1, 2, 3, 4, 5, 6, 7)
val splitArr = "abc".splitAt(1)

List(1, 2, 3)(0)

5 % 5
def loop[A](n: Int)(body: => A): Unit = (0 until n) foreach (n => body)


@tailrec
def addElementToList(numOfTimes: Int, num: Int, accumList: List[Int] = List[Int]()): List[Int] = {
  if (numOfTimes == 0) accumList
  else addElementToList(numOfTimes - 1, num, accumList :+ num)
}



listDuplicater(3, List(1, 2, 3))

def listDuplicater(num: Int, arr: List[Int]) = {
  arr.flatMap(x => addElementToList(num, x))
}


filter(_ < _, List(1, 2, 4, 5, 40), 3)

def filter(fn: (Int, Int) => Boolean, list: List[Int], num: Int, accumList: List[Int] = List[Int]()): List[Int] = {
  list match {
    case Nil => accumList
    case head :: tail => {
      if (fn(head, num)) filter(fn, tail, num, accumList :+ head)
      else filter(fn, tail, num, accumList)
    }
  }
}
listGenerator(10)

def listGenerator(num: Int) = {
  1 to num toList
}

reverseList(List(1, 2, 3))

def reverseList(list: List[Int], accumList: List[Int] = List[Int]()): List[Int] = {

  list match {
    case Nil => accumList
    case head :: tail => reverseList(tail, head +: accumList)
  }

}

def sumOfOddElements(list: List[Int]) = {
  list.filter(_ % 2 != 0).sum
}

def listLength(list: List[Int], count: Int = 0): Int = {
  list match {
    case Nil => count
    case head :: tail => listLength(tail, count + 1)
  }
}
splitArr._2 + splitArr._1
// bca cab abc

def rotateString(str: String, count: Int = 0, accumList: List[String] = List[String]()): String = {
  if (count == str.length) accumList.mkString(" ")
  else {
    val (a, b) = str.splitAt(count + 1)
    rotateString(str, count + 1, accumList :+ b + a)
  }
}
rotateString("abc")

rotateString("abcde")
rotateString("abab")
rotateString("aaa")
rotateString("z")

(1 to 3).foreach(_ => println("Hello World"))


def filterByPostion(arrList: List[Int], countIterator: Int = 1, countNum: Int = 2, accumList: List[Int] = List[Int]()): List[Int] = {
  arrList match {
    case Nil => accumList
    case head :: tail if countIterator % countNum == 0 => filterByPostion(tail, countIterator + 1, countNum, accumList :+ head)
    case head :: tail if countIterator % countNum != 0 => filterByPostion(tail, countIterator + 1, countNum, accumList)
  }
}

filterByPostion(List(1, 2, 3))


def fibonacci(x: Int): Int = {
  if (x == 1) 0
  else if (x == 2) 1
  else fibonacci(x - 1) + fibonacci(x - 2)
}
fibonacci(5)

"abcdpqrs".grouped(2).toList.foldLeft("")((a, b) => a + b.reverse)
"dddd".zip("cccc").foldLeft("")((a, b) => a + b._1 + b._2)

def mingledString(x: String, y: String) = {
  x.zip(y).foldLeft("")((a, b) => a + b._1 + b._2)
}

// Check MingledStringRec
//def mingledStringRec(x:String, y:String, mingledString:String = "") = {
//  if(x.length + y.length == mingledString.length) mingledString
//  else mingledStringRec(x())
//}


def evenOddPermute(str: String) = {
  str.grouped(2).foldLeft("")((a, b) => a + b.reverse)
}



@tailrec
def evenOddPermute(str: String, accumString: String = ""): String = {
  if (str.length == 0) accumString
  else {
    val s = str.splitAt(2)
    evenOddPermute(s._2, accumString + s._1.reverse)
  }
}


def listToAbs(list: List[Int]) = list.map(Math.abs)
listToAbs(List(-1, -2, -3))

def fact(n: Int): Int = {
  @tailrec
  def factHelper(n: Int, res: Int = 1): Int = {
    if (n == 0 || n == 1) res
    else factHelper(n - 1, n * res)
  }

  factHelper(n)
}

def `e^`(x: Double) = {
  (1 to 10).zipWithIndex.map(num => Math.pow(x, num._2) / fact(num._2)).sum
}

printf("%.4f", `e^`(20.0000))


def foldLeft[A, B](l: List[A])(z: B)(f: (A, B) => B): B = {
  l match {
    case Nil => z
    case head :: Nil => f(head, z)
    case head :: tail =>
      val r = f(head, z)
      foldLeft(tail)(r)(f)
  }
}


foldLeft[Int, Int](List(1,2,3))(0)(_ + _)

abstract class Base
case object A extends Base
case object U extends Base
case object G extends Base
case object C extends Base

object Base {
  val fromInt: Int => Base = List(A, U, G, C)
  //val toInt: Base => Int = Map(A -> 0, U -> 1, G -> 2, C -> 3)
}



