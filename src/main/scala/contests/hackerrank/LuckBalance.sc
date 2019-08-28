// Complete the maxMin function below.
def maxMin(k: Int, arr: Array[Int]): Int = {
    val l = arr.sorted.take(k)
    l.last - l.head
}


