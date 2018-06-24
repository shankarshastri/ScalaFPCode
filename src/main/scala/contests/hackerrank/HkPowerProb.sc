import scala.annotation.tailrec

val lis = List(1,2,3)



def loopWithRes[T](n:Int)(block: => T) = (1 to n).map(_ => block).toList

def loopWithIndex[T](n:Int, i:Int= 0)
                    (block: (Int) => T)
                    (accumRes: List[T] = List[T]()): List[T] =
  (i to n).map(index => block(index)).toList




loopWithRes[List[Int]](lis.length) {
  loopWithRes[Int](lis.length){
    lis.length
  }
}

"* * * * * * * * * * * * * * * * * * * * * * *".count(_ == '*')
loopWithIndex[List[(Int, Int)]](lis.length) {
  (i: Int) => loopWithIndex[(Int, Int)](lis.length, i = i+1) {
    (j: Int) => (i,j)
  }()
}()

for {
  i <- 0 to lis.length - 1
} yield {
  for{
    j <- 0 to lis.length -1
    if i!=j
  } yield j
}

//def powerSetSum[A](t: Set[A], sum: A): Set[Set[A]] = {
//  @annotation.tailrec
//  def pwr(t: Set[A], ps: Set[Set[A]]): Set[Set[A]] = {
//
//
//
//    if (t.isEmpty) ps
//    else pwr(t.tail, ps ++ (ps map (_ + t.head)))
//  }
//
//  pwr(t, Set(Set.empty[A]))
//}

@tailrec
def constructPowerList(n:Int, max:Int, accumList: List[Double] = List[Double](),
                       index:Int = 1 ): List[Int] = {
  val powVal = Math.pow(index, n)
  if(powVal <= max) {
    constructPowerList(n, max, powVal :: accumList ,index+1)
  } else accumList.map(_.toInt)
}

def powerSetSum(t: Set[Int], sum: Int): Int = {
  @tailrec
  def pwr(t: Set[Int], ps: Set[Set[Int]], count: Int=0): Int = {
    if (t.isEmpty) count
    else {
      val set = (ps map (x => x + t.head))
      pwr(t.tail, (ps ++ (set)), count + set.count(_.sum == sum))
    }
  }
  pwr(t, Set(Set.empty[Int]))
}

// Complete the powerSum function below.
def powerSum(X: Int, N: Int): Int = {
  val values = constructPowerList(N, X)
  powerSetSum(values.toSet, X)
}


powerSum(100, 2)