val arr = Array.fill(10)(0)
val updatedValue = 100
(0 to 1).foreach(e =>  arr.update(e, arr(e) + 100))
arr


//for(i=0;i<K;i++)
//{
//  cin>>p>>q>>sum;
//  a[p]+=sum;
//  if((q+1)<=N) a[q+1]-=sum;
//}
//
//for(i=1;i<=N;i++)
//{
//  x=x+a[i];
//  if(max<x) max=x;
//
//}
//
//1 2 100
//2 5 100
//3 4 100


//
//be 100 100 0 0 0. (100, 0, -100, 0, 0)
//After the second update list will be 100 200 100 100 100. (100, 100, -100, 0, 0)
//After the third update list will be 100 200 200 200 100. (100, 100, 0, 0, -100)
//The required answer will be .

//arr(0,0,0,0,0) => arr(100, 100, 0 , 0 , -100)
import java.io._
object Solution {
  
  // Complete the arrayManipulation function below.
  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    val arr = Array.fill(n+1)(BigInt(0))
    queries.foreach{
        e => {
          val Array(a, b, k) = e
          (a to b).foreach(ele => arr.update(ele, arr(ele) + k))
        }
    }
    arr.max.longValue()
  }
  
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val nm = stdin.readLine.split(" ")
    val n = nm(0).trim.toInt
    val m = nm(1).trim.toInt
    val queries = Array.ofDim[Int](m, 3)
    for (i <- 0 until m) {
      queries(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }
    val result = arrayManipulation(n, queries)
    printWriter.println(result)
    printWriter.close()
  }
}
