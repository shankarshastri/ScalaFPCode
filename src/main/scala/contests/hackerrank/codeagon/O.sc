import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

def powerSet[A](t: Set[A]): Set[Set[A]] = {
  @annotation.tailrec
  def pwr(t: Set[A], ps: Set[Set[A]]): Set[Set[A]] = {
    if (t.isEmpty) ps
    else pwr(t.tail, ps ++ (ps map (_ + t.head)))
  }
  pwr(t, Set(Set.empty[A]))
}


powerSet(Set(1,2,3,4,5)).size

val list = List[BigInt](29, 39, 3292, 324)


//def bobXor(list: List[BigInt]): BigInt = {
//  val res = for {
//    i <-  0 until list.length
//    j <- i until list.length
//  } yield {
//    (i+1 to j).scanLeft(list(i))((a,b) => a | list(b))
//  }
//  res.sum
//}

var j = 1
val res=  for {
  i <-  0 until list.length
} yield {
  (i+1 until list.length).scanLeft(list(i))((a,b) => a | list(b)).sum
}

res.sum
//bobXor(list)


val f = list.tail.foldLeft(list.head)(_ | _)


val s = for {
  i <- 0 until list.length
} yield {
  list(i) | f
}
s.sum
//
//object Solution {
//  def bobXor(list: List[BigInt]): BigInt = {
//    val res = for {
//      i <-  list.indices
//    } yield {
//      (i+1 until list.length).scanLeft(list(i))((a,b) => a | list(b)).sum
//    }
//    res.sum
//  }
//
//  import scala.io.StdIn._
//  def main(args: Array[String]) {
//    readLine
//    println(bobXor(readLine().split(" ").map(BigInt(_)).toList))
//  }
//}



def prefixOrArr(l: List[BigInt]): BigInt = {
  @tailrec
  def prefixOrArrHelper(l: List[BigInt], accumResult: List[BigInt] = List[BigInt]()): List[BigInt] = {
    l match {
      case head :: Nil => ((accumResult.head | head) :: accumResult).reverse
      case head :: tail => prefixOrArrHelper(tail, (accumResult.head | head) :: accumResult)
    }
  }
  
  prefixOrArrHelper(l.tail, List(l.head)).sum
}


def calcPrefixOrArr(l: List[BigInt]): BigInt = {
  l match {
    case head :: Nil => head
    case head :: tail => calcPrefixOrArr(tail) | head
  }
}



val list1 = List[BigInt](29, 39, 3292, 324)
prefixOrArr(list1)
calcPrefixOrArr(list1)
Integer.MAX_VALUE / Math.pow(10, 9).toInt


//
//// function to find the OR_SUM
//int ORsum(int arr[], int n)
//{
//  // create an array of size 32
//  // and store the sum of bits
//  // with value 0 at every index.
//  int zerocnt[INT_SIZE] = { 0 };
//
//  for (int i = 0; i < INT_SIZE; i++)
//  for (int j = 0; j < n; j++)
//  if (!(arr[j] & 1 << i))
//    zerocnt[i] += 1;
//
//  // for each index the OR sum contributed
//  // by that bit of subset will be 2^(bit index)
//  // now the OR of the bits is 0 only if
//  // all the ith bit of the elements in subset
//  // is 0.
//  int ans = 0;
//  for (int i = 0; i < INT_SIZE; i++)
//  {
//    ans += ((pow(2, n) - 1) -
//      (pow(2, zerocnt[i]) - 1)) *
//      pow(2, i);
//  }
//
//  return ans;
//}
//
List.fill(32)(0)


def orSum(l: List[Int]) = {
  val bitList = ListBuffer.fill(32)(0)
  for {
    i <- 0 until bitList.length
    j <- 0 until l.length
    _ = println(l(j) & 1)
    if ((l(j) & 1) << i) != 0
  } {
    bitList.update(i, bitList(i)+1)
  }
  (0 until bitList.length).foldLeft(0.0)((a,b) => {
    a + (Math.pow(2, l.length) - 1) - (Math.pow(2, bitList(b)) - 1) * Math.pow(2, b)
  })
}

orSum(List[Int](1,2,3))