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
//def checkEvenAndDivide(n: BigInt): BigInt = {
//  n match {
//    case x if x % 2 == 0 => checkEvenAndDivide(n/2)
//    case _ => n
//  }
//}
//
//
////def sqrt
////
////def oddPrimeFactor(n: BigInt): BigInt = {
////  3 to
////}
//
//
////def largePrimeFactor(n: BigInt): BigInt = {
////
////}

BigDecimal(10.0304).setScale(2)
//
//def tailRecursiveSqRoot(n: BigDecimal) ={
//
//}
//
//36 * 36
//
val n:BigDecimal = 1296
val x0: BigDecimal = 1
(1 to 10).scanLeft(x0)((a,_) => {
  (a+n/a)/2
})

List[Int](1,2,3)