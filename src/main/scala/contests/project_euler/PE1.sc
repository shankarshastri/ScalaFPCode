import scala.annotation.tailrec
//1,2,3,4,5,6,7,8

BigInt(97).isProbablePrime(1)
//def f(n: BigInt) = {
//  if(n.isProbablePrime())
//}





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


def primeCheck(n:BigInt): Boolean = {
  @tailrec
  def primeCheckHelper(index: BigInt): Boolean = {
    n match {
      case n if n % index == 0 => false
      case n if n % index == 0 && index == sqroot(BigDecimal(n)) => false
      case n if index <= sqroot(BigDecimal((n))) => true
      case _ => primeCheckHelper(index + 1)
    }
  }
  primeCheckHelper(3)
}



//(BigInt(1) to BigInt(1000)).map(isPrime(_))

def isPrime(n: BigInt): Boolean = {
  if(n % 2 == 0 && n!=2) false
  else {
      primeCheck(n)
  }
}


def generatePrimeNumbers(): List[BigInt] = {
  val res = for {
    i <- BigInt(2) to BigInt(10002)
    if isPrime(i)
  } yield i
  res.toList
}

//generatePrimeNumbers
//
//def generat