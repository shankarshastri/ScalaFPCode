
object MiniMax {
  
  // Complete the miniMaxSum function below.
  def miniMaxSum(arr: Array[Int]) {
    val sortedArr = arr.map(BigInt(_)).sorted
    println(s"${sortedArr.init.sum} ${sortedArr.tail.sum}")
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    
    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    miniMaxSum(arr)
  }
}
