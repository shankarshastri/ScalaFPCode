val s = 11

val l = Array(3,5,1, 2)
val minList = Array.fill(s+1)(Int.MaxValue)
minList(0) = 0



for {
  i <- 1 to s
}  {
  for {
    j <- 0 to l.length - 1
  }  {
    if(l(j) <= i && minList(i - l(j)) < minList(i)) {
      minList(i) = minList(i - l(j)) + 1
    }
  }
}

println(minList.mkString(" "))

//Set Min[i] equal to Infinity for all of i
//Min[0]=0For i = 1 to S
//For j = 0 to N - 1If (Vj<=i AND Min[i-Vj]+1 < Min[i])
//Then Min[i]=Min[i-Vj]+1Output Min[S]

