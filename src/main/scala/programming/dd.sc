import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Success, Try}

val l = List(1, 2, 3, 4)
Future(Future.failed(new Exception("Hello"))).map(x => x).map(x => x).map(x => x)

//https://stackoverflow.com/questions/11581175/how-to-generate-the-power-set-of-a-set-in-scala
l.toSet.subsets().toList
val T = Set(1, 2, 3)
val S = Set(1, 2, 3)

val assertBoolean = (x: Boolean) => Try(assert(x)) match {
  case Success(()) => true
  case _ => false
}
assertBoolean(T == S + 3)
// subset => {1}, {2}, {3}, {1,2}, {1,3}, {2, 3}, {1,2,3}
val `06` = "000000"

//base64
Set(Set(1, 2), Set(1), Set(1, 2))
val strOfChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
val base64Map = (strOfChar zipWithIndex).map(x => (x._2, x._1)).toMap
val res = base64("ORACLE")
val se = "ORACLEEEE"

def powerSet[A](t: Set[A]): Set[Set[A]] = {
  @annotation.tailrec
  def pwr(t: Set[A], ps: Set[Set[A]]): Set[Set[A]] = {
    if (t.isEmpty) ps
    else pwr(t.tail, ps ++ (ps map (_ + t.head)))
  }

  pwr(t, Set(Set.empty[A]))
}

def replaceLastCharOccur(str: String, ch: Char, chToReplace: Char) = {
  str.reverse.find(_ != ch) match {
    case Some(x) => {
      val splittedTuple = str.splitAt(str.length - str.indexOf(x))
      if (splittedTuple._2.distinct.length == 1 || splittedTuple._2.distinct.length == 0)
        splittedTuple._1 + chToReplace.toString * splittedTuple._2.length
      else str
    }
    case _ => str
  }
}

//TODO Replace the last padding bit by =
def base64(str: String) = {
  val list = breakAndAppend(constructBinFromString(str))
  list.map(ele => base64Map(Integer.parseInt(ele, 2))).mkString
}

def constructBinFromString(str: String) = {
  val seq = str.map(_.toBinaryString)
  seq.map(x => {
    pad0s(x, 8) + x
  }).mkString
}

def pad0s(str: String, lengthForPad: Int) = {
  require(str.length <= lengthForPad)
  "0" * (lengthForPad - str.length)
}

def breakAndAppend(str: String) = {
  val list = str.grouped(6).toList
  val lastElement = list.last
  val lastElementLength = lastElement.length
  lastElementLength match {
    case 8 => list
    case _ => {
      val appendedStringTuple = appendPadding(lastElement)
      list.init ::: List(appendedStringTuple._1) ::: List(appendedStringTuple._2)
    }
  }
}

def appendPadding(lastElement: String) = {
  val diff0s = pad0s(lastElement, 6)
  (lastElement + diff0s, pad0s("", 6))
}


replaceLastCharOccur(se, 'F', '=')