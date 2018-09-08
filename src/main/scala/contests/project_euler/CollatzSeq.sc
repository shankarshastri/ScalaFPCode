
import scala.annotation.tailrec

val n = 13

@tailrec
def collatzSequence(s: BigInt, count: BigInt = 0): BigInt = {
  //  println(s, count)
  s match {
    case s if s == 1 => count
    case s if s % 2 == 0 => collatzSequence(s / 2, count + 1)
    case s => collatzSequence(3 * s + 1, count + 1)
  }
}

// CollatzSeq Implementation With Memoization/Caching Only For Odd Numbers
object CollatzSeq {
  private final val mapOfCollatzSequence =
    scala.collection.mutable.HashMap[BigInt, BigInt]()
      .withDefaultValue(0)
  
  def longestCollatzSeq(n: BigInt): BigInt = {
    def longestCollatzSeqHelper(n: BigInt, count: BigInt = 0): BigInt = {
      val mapValueOfN = mapOfCollatzSequence(n)
      n match {
        case n if n == 1 => count
        case _ if mapValueOfN != 0 =>
          count + mapValueOfN
        case n if n % 2 == 0 =>
          val updateForEven = longestCollatzSeqHelper(n/2, count + 1)
          mapOfCollatzSequence.update(n, updateForEven - count)
          updateForEven
        case n if n % 2 != 0 =>
          val c = longestCollatzSeqHelper(3 * n + 1 , count + 1)
          mapOfCollatzSequence.update(n, c - count)
          c
      }
    }
    longestCollatzSeqHelper(n)
  }
}

val maxLimit = 5 * 1000 * 1000
//(BigInt(2) to BigInt(maxLimit)).map(e => CollatzSeq.longestCollatzSeq(e))
CollatzSeq.longestCollatzSeq(maxLimit) == collatzSequence(maxLimit)