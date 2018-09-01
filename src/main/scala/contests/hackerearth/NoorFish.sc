//1
//3
//4 1
//5 4
//7 3
//1 4
//6 5






//case class NoorFish(size: BigInt, eatingFactor: BigInt)
//
//List[NoorFish](NoorFish(4,1), NoorFish(5,4), NoorFish(7,3), NoorFish(1,4),
//  NoorFish(6,5)).sortBy(_.size)
//
//
//
//
//List[(Int, Int)]((4,1), (5,4), (7,3))
//  .flatMap(e => List[(Int, Int)]((e._1, -1), (e._2, 1)))
//  .sorted





//vector<int> prefix_function(string s) {
//  int n = (int)s.length();
//  vector<int> pi(n);
//  for (int i = 1; i < n; i++) {
//    int j = pi[i-1];
//    while (j > 0 && s[i] != s[j])
//      j = pi[j-1];
//    if (s[i] == s[j])
//      j++;
//    pi[i] = j;
//  }
//  return pi;
//}
//

val s = "aabaaab"


val n = s.length


def prefix_function(s: String): List[Int] = {
    val n = s.length
    val pi = scala.collection.mutable.ListBuffer.fill(s.length)(0)
    println(s)
    for {
        i <- 1 until n
    } yield {
        var j = pi(i-1)
        println(pi)
        println(i,s(i))
        println(j,s(j))

        while(j > 0 && s(i) != s(j))
            j = pi(j-1)
        if(s(i) == s(j))
            j += 1
        pi(i) = j
    }
    pi.toList
}


prefix_function(s)

