def josephus(n: Int, k: Int): Int = {
  if(n == 1) 1
  else {
    val res = (k - 1 + josephus(n-1, k)) % n + 1
    println(res)
    println(n)
    res
  }
}

josephus(26, 17)

//1,2,3,5,8,13
"BABABBABABBABBABABBAB"
"BABABBABABBABBABABBABABBABBABABBABBABABBABABBABBABABBAB"

def fib(n: Int) = {
  val sqrt_5 = Math.sqrt(5)
  val phi = (1 + sqrt_5) / 2
  val fib_n = Math.pow(phi, n) / sqrt_5
  (fib_n + 0.5).toInt
}


fib(6)//1,1,2,3,5,8