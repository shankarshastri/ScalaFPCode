/**
  * @author ShankarShastri
  *         Algorithm: PE7
  */
package contests.project_euler

import scala.io.StdIn._
import scala.annotation.tailrec

object SieveOfErastothene {

  def loopForErastothenes(n: BigInt,
                          index: BigInt,
                          map: Map[BigInt, Boolean]): Map[BigInt, Boolean] = {
    @tailrec
    def loopForErastonthenesHelper(map: Map[BigInt, Boolean],
                                   mul: BigInt = 0): Map[BigInt, Boolean] = {
      val indexSq = (index * index) + mul * index
      if (indexSq < n) {
        loopForErastonthenesHelper(map.updated(indexSq, false), mul + 1)
      } else map
    }

    loopForErastonthenesHelper(map)
  }

  def sqroot(n: BigDecimal, x0: BigDecimal = 1): BigInt = {
    @tailrec
    def sqrootHelper(xn: BigDecimal): BigDecimal = {
      val cal =
        ((xn + n / xn) / 2).setScale(0, BigDecimal.RoundingMode.HALF_EVEN)
      val roundedXn = xn.setScale(0, BigDecimal.RoundingMode.HALF_EVEN)
      roundedXn match {
        case x if cal == x =>
          cal
        case _ => sqrootHelper(cal)
      }
    }

    sqrootHelper(x0).toBigInt
  }

  def sieveOfErastothenes(n: BigInt): List[BigInt] = {
    @tailrec
    def sieveOfErastothenesHelper(
        index: BigInt = 2,
        map: Map[BigInt, Boolean] =
          Map[BigInt, Boolean]().withDefaultValue(true)): List[BigInt] = {
      if (index < sqroot(BigDecimal(n)) && map(index)) {
        sieveOfErastothenesHelper(index + 1, loopForErastothenes(n, index, map))
      } else if (index < sqroot(BigDecimal(n))) {
        sieveOfErastothenesHelper(index + 1, map)
      } else
        List.range(BigInt(2), n) diff map.map(_._1).toList
    }

    sieveOfErastothenesHelper()
  }
}

object PE7 {
  import SieveOfErastothene._
  @tailrec
  def loopWithResForBigInt[T](n: BigInt)(block: => T)(
      res: List[T] = List[T]()): List[T] = {
    n match {
      case x: BigInt if x == BigInt(0) => res
      case _                           => loopWithResForBigInt(n - 1)(block)(block :: res)
    }
  }


  def main(args: Array[String]): Unit = {
    val t = readInt
    val list = sieveOfErastothenes(110000)
    loopWithResForBigInt(t) {
      val n = readInt
      println(list(n-1))
    }()
  }
}
