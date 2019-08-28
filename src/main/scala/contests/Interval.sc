
import scala.math._
def countOfConsecutiveBinOne(n: Int): Int = {
  def countOfConsecutiveBinOneHelper(s: String, res: Int = 0): Int = {
    println(s)
    if (s.length == 0) res
    else {
      val index0 = s.indexWhere(_ == '0')
      println(index0)
      if(index0 == -1){
        println("if")
        max(s.lastIndexOf("1"), res)
      }
      else {
        println("else")
        println(s.splitAt(index0)._2)
        countOfConsecutiveBinOneHelper(s.splitAt(index0)._2,
          max(index0, res))
      }
    }
  }
  countOfConsecutiveBinOneHelper(n.toBinaryString)
}

countOfConsecutiveBinOne(2)