import scala.annotation.tailrec
import scala.collection.concurrent.TrieMap
import scala.collection.mutable

val Array(n,k) = "9 5".split(" ").map(_.toInt)
val l = "2 3 4 2 3 6 8 4 5".split(" ").map(_.toInt).toList


implicit class listOps(l: List[Int]) {
  def median:Int = {
    (l.length % 2 == 0) match {
      case true => (l(l.length/2) + l(l.length/2 -1))/2
      case _ => l(l.length/2)
    }
  }
}





l.sliding(5).toList.map(_.sorted.median)
(1/3.0)
1/4.0
(1/7.0)







object UnitFractionCalc {
  private val cacheOfUnitFracCount = TrieMap[Double, Int]()

  def unitFractionUniqueCount(d: Double): Int = {
    cacheOfUnitFracCount.
      getOrElseUpdate(d, BigDecimal(d).pow(-1).toString.split("\\.").tail.head.distinct.length)
  }

  def getMaxCountFromCache() = {
    cacheOfUnitFracCount
      .toList
      .sortWith((a,b) => a._1 < b._1)
      .sortWith((a,b) =>  a._2 > b._2)
      .head
  }
}

//(1 to 100).map(UnitFractionCalc.unitFractionUniqueCount(_))
//
//UnitFractionCalc.getMaxCountFromCache()

1/3.0
BigDecimal(97.0).pow(-1).toString.split("\\.").tail.head.distinct.length


(Math.pow(10, 12) - 1)/13


subsetWithUniqueSum("1 3 6 8 10 11".split(" ").map(_.toInt).toSet, 3)


def subsetWithUniqueSum(s: Set[Int], n: Int) = {
  val res = s.subsets(n).map(_.sum).toList
  val distRes = res.distinct
  distRes.diff(res.diff(distRes)).sum
}

val k1 = "-59 -36 -13 1 -53 -92 -2 -96 -54 75".split(" ").map(_.toInt).toList


k1.sorted.sliding(2).toList.map(e => Math.abs(e.head - e.tail.head)).min

def minAbsoluteDiff(l: List[Int]):Int = {
  l match {
    case head :: head1 :: Nil => Math.abs(head - head1)
    case head :: tail => {
      Math.min(tail.map(e => Math.abs(head - e)).min, minAbsoluteDiff(tail))
    }
  }
}


def minAbsoluteDiffShort(l: List[Int]): Int = {
  l.sorted.sliding(2).toList.map(e => Math.abs(e.head - e.tail.head)).min
}
minAbsoluteDiff(k1)



def downToZero(n: Int):Int = {
  
  implicit class TupleMath(t: (Int, Int))  {
    def max = if(t._1 > t._2) t._1 else t._2
  }
  
  def maxFactorOfNumber(n: Int): (Int, Int) = {
    val i = (Math.sqrt(n).toInt to 2 by -1).find(n % _ == 0).getOrElse(1)
    (n / i, i)
  }
  
  @tailrec
  def downToZeroHelper(n: Int, accum: Int = 0): Int = {
    n match {
      case 0 => accum
      case _ =>
        println(n)
        val (a,b) = maxFactorOfNumber(n)
        println(a,b)
        if(a == 1 || b == 1) downToZeroHelper(a-1, accum+1)
        else downToZeroHelper(Math.min(maxFactorOfNumber(n).max, n-1), accum+1)
    }
  }
  downToZeroHelper(n)
}

downToZero(877345)
