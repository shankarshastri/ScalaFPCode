package programming

import scala.io.StdIn._

object StringDiff {

  def main(args: Array[String]): Unit = {
    val s1 = readLine
    val s2 = readLine

    val prefixLength = (s1 zip s2).prefixLength(x => x._1 == x._2)
    val prefix = s1.splitAt(prefixLength)._1
    val s1Sub = s1.splitAt(prefixLength)._2
    val s2Sub = s2.splitAt(prefixLength)._2

    println(`printIfLength>0`(prefix))
    println(`printIfLength>0`(s1Sub))
    println(`printIfLength>0`(s2Sub))
  }

  def `printIfLength>0`(s: String): String = {
    if (s.length > 0) s"${s.length} ${s}"
    else "0"
  }

}
