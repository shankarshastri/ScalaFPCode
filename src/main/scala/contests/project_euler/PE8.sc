val n = "3675356291"
val k = 5




def consecSumOfNumbers(n: BigInt): BigInt = {
  if(n == 0) 0
  else n%10 + consecSumOfNumbers(n/10)
}

def consecProductOfNumbers(n: BigInt): BigInt = {
  if(n == 0) 1
  else n%10 * consecProductOfNumbers(n/10)
}


val slidingList = n.sliding(k).toList.take(k).map(BigInt(_))
val consecListOfSum = slidingList.map(x => (x, consecSumOfNumbers(x)))
val max = consecListOfSum.max._2

consecListOfSum.filter(_._2 == max).map(x => {
  consecProductOfNumbers(x._1)
}).max
"3675356291".sliding(5).toList



"345555555"

consecProductOfNumbers(3050000)