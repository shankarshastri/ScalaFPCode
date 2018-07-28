

"123"

"12" + "12"


val str = "51215"
if(str.length % 2 == 0) {
  str.substring(0, str.length/2) + str.substring(0, str.length/2).reverse
} else {
  str.substring(0, str.length/2 + 1) + str.substring(0, str.length/2).reverse
}



def generateClosestPalindrome(str: String): String = {
  if(str.length == 1) {
    if(str.toInt - 1 > 0) (str.toInt - 1).toString else "0"
  }
  else if(str.length % 2 == 0) {
    str.substring(0, str.length/2) + str.substring(0, str.length/2).reverse
  } else {
    str.substring(0, str.length/2 + 1) + str.substring(0, str.length/2).reverse
  }
}



generateClosestPalindrome("215")



object Solution {
  def generateClosestPalindrome(str: String): String = {
    if(str.length == 1) {
      if(str.toInt - 1 > 0) (str.toInt - 1).toString else "0"
    }
    else if(str.length % 2 == 0) {
      str.substring(0, str.length/2) + str.substring(0, str.length/2).reverse
    } else {
      str.substring(0, str.length/2 + 1) + str.substring(0, str.length/2).reverse
    }
  }

  def nearestPalindromic(n: String): String = {
    generateClosestPalindrome(n)
  }
}



//1,2,3,4,5,6,7,8,9
//11,22,33,44,55,66,77,88,99
//101, 111, 121, 131,141,151,
//202
//
//def generateListOfPalindromes(s: BigInt, e: BigInt): List[BigInt] ={
//
//
//}

999 * 999


def isPalindrome(x: Int) = {
  x.toString == x.toString.reverse
}

val res =
  for {
    i <- 100 to 999
    j <- i to 999
    if i!=j && isPalindrome(i * j)
  } yield i * j



