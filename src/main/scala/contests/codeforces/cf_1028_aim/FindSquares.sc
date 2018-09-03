
def twoSum(nums: Array[Int], target: Int): (Int, Int) = {
  var flag = true
  val vec = for {
    i <- 0 until nums.length
    j <- 0 until nums.length
    if (nums(i) + nums(j) == target) && (i != j) && (flag == true)
  } yield {
    flag = false
    (i, j)
  }
  (vec.head._1 + 1, vec.head._2 + 1)
}



val a = "2 2 4 3".split(" ").map(_.toInt)
twoSum(a, 4)



import java.io._
object Solution {
  
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var flag = true
    val vec = for {
      i <- 0 until nums.length
      j <- 0 until nums.length
      if (nums(i) + nums(j) == target) && (i != j) && (flag == true)
    } yield {
      flag = false
      (i, j)
    }
    Array[Int](vec.head._1 + 1, vec.head._2 + 1)
  }
  
  // Complete the icecreamParlor function below.
  def icecreamParlor(m: Int, arr: Array[Int]): Array[Int] = {
    twoSum(arr, m)
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val t = stdin.readLine.trim.toInt
    for (tItr <- 1 to t) {
      val m = stdin.readLine.trim.toInt
      val n = stdin.readLine.trim.toInt
      val arr = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = icecreamParlor(m, arr)
      printWriter.println(result.mkString(" "))
    }
    printWriter.close()
  }
}
