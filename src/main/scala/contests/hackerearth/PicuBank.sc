import scala.annotation.tailrec
// D dollars
// Every Month A dollar to account till M months
// After M month, that is M+1 month add B dollar (B<A)
// M+2 month => add A, M+3 => add B
// X amount requires how many month.


//2 5 4 3 51
// D A M B X
// 1 2 4 1 51
2 + (5*4) + 3

//2+(4*5)+3+(4*5)+3+5
 2 +  (5 * 4) + 3 + 5 + 3 + 5 + 3 + 5 + 3 + 5
// D + A * M + B + A + B + A

// (D + A*M) + (B*X + A*Y)
// noOfMonth = M + (X+Y)
// (B*X + A*Y) = $X - (D + A*M)
//NoOfMonth = 4
// 2 +  5 * 4
// D + A * M



// 24 , 24, 29
// A, B, C
// B-A, C-A
// 0, 5
val $X = 51 - (2 +  (5 * 4))
val cal = 5 * 4 + 3 * 3
// (5+3) + (5+3) + (5+3)

//2 5 4 3 46
//

val $X1 = 46 - (2 + 5*4)


def calcResultForX(X: BigInt, a: BigInt, b: BigInt): BigInt = {
  @tailrec
  def calcResultForXHelper(index: BigInt, result: BigInt = 0): BigInt = {
    if(result > X) {
      val resA = (X - (result - a - b)).abs
      val resB = (X - (result - b)).abs
      resA min resB match {
        case r if r == resA =>
          (index - 2) * 2
        case r if r == resB => ((index - 1) * 2) - 1
      }
    } else {
      calcResultForXHelper(index+1, result+a+b)
    }
  }
  calcResultForXHelper(1)
}

def picuBank(d: BigInt, m: BigInt, a: BigInt, b: BigInt, x:BigInt): BigInt = {
  val calcX = x - (d + a * m)
  if(calcX < 0) m
  else m + calcResultForX(calcX, a, b)
}
//2
//3 6 3 5 60
//5 8 5 4 70
// 50 40 35 15 150
 picuBank(2, 4, 5, 3, 51)