import scala.concurrent.{Await, Future}
import scala.util.DynamicVariable

//val l = "2 2 2 2".split(" ").map(_.toInt).toList
//
//val keys = "0 1 7 9".split(" ").map(_.toInt).toList
//
//
//
////
////3 4 1 0
////0 1 7 9
//keys.map(x => (x, l.indexOf(x))).filter(_._2 != -1).sortBy(_._2).map(_._1)
//
////
////val data = Map("test" -> 113123, "cat" -> None, "myList" -> Map("test2" -> 321323, "test3" -> 11122))
////data map {
////  case x: Map[String, _] => x._1 -> Some(x)
////  case x => x
////}
//
//
//
//
//def quickSort(list: List[Int]): List[Int] = {
//  if(list.length < 2) list
//  else {
//    val partitionElement = list(list.length / 2)
//    println(partitionElement)
//    quickSort(list.filter(_ < partitionElement)) ++ list.filter(_ == partitionElement) ++ quickSort(list.filter(_ > partitionElement))
//  }
//}
//quickSort(List(3,2,2,1, 20000))
//
//
//
//case class Product(name: String, code: String, clientId: String)
//
//val list =
//  List(Product("s", "s", "s1"),Product("s", "s", "s2"),Product("s", "s", "s1"),Product("s", "s", "s2"),Product("s", "s", "s3"),
//    Product("s", "s", "s1"),Product("s", "s", "s2"),Product("s", "s", "s1"),Product("s", "s", "s2"),Product("s", "s", "s3"),
//    Product("s", "s", "s1"),Product("s", "s", "s2"),Product("s", "s", "s1"),Product("s", "s", "s2"),Product("s", "s", "s3"))
//val distinctClientId = list.map(_.clientId).distinct
//
//distinctClientId.map(x => list.filter(_.clientId == x).take(3))

//def readLineToList[T](str: String) = str.split(" ").map(_.to).toList
//
//
//val x = 2
//val list = readLineToList[Int]("3 1 2 1 3")
//

//
//
//def solveContestForMiska(list: List[Int], k: Int) = {
//  val leftList =  list.takeWhile(_ <= k)
//  leftList.length + list.splitAt(leftList.length)._2.reverse.takeWhile(_ <= k).length
//}
//
//solveContestForMiska(list, x)


//s"[${(1 to n-1).map(_ => str).mkString(",")},${str}]"



val args = Array[String]("aaaa","10")
//val x = s"println(\"${args.mkString}\")"
println("println("+args.mkString+")")
//def f(n:Int) =

//(1 to 10).map(_ => "10".concat( ","))
//val n = 10
//(1 to n).foreach(_ => println(s"[${nn.toString}]"))

