import scala.annotation.tailrec
import scala.util.Random

List[Int](111)
val res = checkEvenAndDivide(BigInt("25698751364526"))
//
//
////def sqrt

//import scala.annotation.tailrec
//
//val n = 17
//
//
//@tailrec
//def closePrimeFactor(n: BigInt, res: BigInt): BigInt = {
//  val checkDivisors = ((2 to 9).filter(n % _ == 0).length > 0) && n > 9
//  if(checkDivisors) {
//    closePrimeFactor(n-1, res)
//  } else {
//    if(res % n == 0) n
//    else closePrimeFactor(n-1, res)
//  }
//}
//
//closePrimeFactor(BigInt("44100"), BigInt("44100"))
//
//
//
//BigInt(100)
//
//
//BigDecimal(10.0).setScale(2)
//
////def sqrtNewtonsMethod(n: BigDecimal) ={
////
////}
//
//
//
def checkEvenAndDivide(n: BigInt): BigInt = {
  n match {
    case x if x % 2 == 0 => checkEvenAndDivide(n/2)
    case _ => n
  }
}




def oddPrimeFactor(n: BigInt, begin: BigInt = 3): (BigInt, BigInt) = {
  def oddPrimeFactorHelper(n1: BigInt, begin: BigInt, res: BigInt = -1): (BigInt, BigInt) = {
    if(begin >= sqroot(BigDecimal(n1))) {
      (n1, res)
    }
    else {
      if(n1 % begin == 0) {
        oddPrimeFactorHelper(n1 / begin, begin + 2, begin)
      }
      else
        oddPrimeFactorHelper(n1, begin + 2, res)
    }
  }
  
  oddPrimeFactorHelper(n, begin)
}
oddPrimeFactor(res)

def largePrimeFactor(n: BigInt): BigInt = {
  val (n1, maxPrime) = oddPrimeFactor(checkEvenAndDivide(n))
  if(n1 > 2) n1 else maxPrime
}

largePrimeFactor(15)


def sqroot(n: BigDecimal, x0: BigDecimal=1): BigInt = {
  @tailrec
  def sqrootHelper(xn: BigDecimal): BigDecimal = {
    val cal = ((xn+n/xn)/2).setScale(0, BigDecimal.RoundingMode.HALF_EVEN)
    val roundedXn = xn.setScale(0, BigDecimal.RoundingMode.HALF_EVEN)
    roundedXn match {
      case x  if cal == x =>
        cal
      case _ => sqrootHelper(cal)
    }
  }
  sqrootHelper(x0).toBigInt
}



sqroot(100)



def loopWithResForBigInt[T](n: BigInt)(block: => T)(res: List[T] = List[T]()): List[T] = {
  n match {
    case x: BigInt if x == BigInt(0) => res
    case _ => loopWithResForBigInt(n-1)(block)(block :: res)
  }
}

loopWithResForBigInt(10) {
  2
}()



  
  SieveOfErastothene.sieveOfErastothenes(10)
//val x = "110000"* 1000
//BigInt(x)