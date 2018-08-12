val n = 100
val x = 2

object SolutionP {
  
  def main(args: Array[String]) {
    println(numberOfWays(readInt(), readInt()))
  }
  
  def numberOfWays(X: Int, N: Int): Int = {
    // Compute the answer in this function over here
    // It is fine to define new functions as and where required
    val maxNum = Math.sqrt(X).toInt
    val powList = (1 to maxNum).filter(Math.pow(_, N).toInt <= X)
      .map(Math.pow(_, N).toInt).toList
    subsetSum(powList, powList.length, X)
  }
  
  def subsetSum(l: List[Int], n: Int, sum: Int): Int = {
    if (sum == 0) 1
    else if (sum != 0 && n == 0) 0
    else subsetSum(l, n - 1, sum) + subsetSum(l, n - 1, sum - l(n - 1))
  }
}

SolutionP.numberOfWays(1000, 10)