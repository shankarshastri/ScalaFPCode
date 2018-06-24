

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



generateClosestPalindrome("100")



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