//procedure karatsuba(num1, num2)
//if (num1 < 10) or (num2 < 10)
//return num1*num2
///* calculates the size of the numbers */
//m = max(size_base10(num1), size_base10(num2))
//m2 = floor(m/2)
///* split the digit sequences in the middle */
//high1, low1 = split_at(num1, m2)
//high2, low2 = split_at(num2, m2)
///* 3 calls made to numbers approximately half the size */
//z0 = karatsuba(low1, low2)
//z1 = karatsuba((low1 + high1), (low2 + high2))
//z2 = karatsuba(high1, high2)
//return (z2 * 10 ^ (m2 * 2)) + ((z1 - z2 - z0) * 10 ^ m2) + z0





def size_base10(n: Long):Long = {
  if(n/10 == 0) 1 else 1 + size_base10(n/10)
}

def splitNum(num: Long, n:Long):(Long, Long) = {
  val res = num.toString.splitAt(n.toInt)
  (res._1.toLong, res._2.toLong)
}


def karatsuba(x:Long, y:Long): Long = {
  if((x < 10) || (y <10)) x*y
  else {
    val m = size_base10(x) max size_base10(y)
    val `m/2` = Math.floor(m/2).toInt
    val (high1, low1) = splitNum(x, `m/2`)
    val (high2, low2) = splitNum(y, `m/2`)
    val z0 = karatsuba(low1, low2)
    val z1 = karatsuba((low1 + high1), (low2 + high2))
    val z2 = karatsuba(high1, high2)
    (Math.pow(z2 * 10 , `m/2` * 2) + (z1 - z2 - z0) * Math.pow(10, `m/2`) + z0).toLong
  }
}

karatsuba(12345, 6789)
12345 * 6789
//83810205