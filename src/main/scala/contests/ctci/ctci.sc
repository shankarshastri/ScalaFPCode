val a = List(7,1,6)
val b = List(5,9,2)

a zip b

val res = a.zip(b).foldLeft((List.empty[Int], 0))((a,b) => {
  if(b._1 + b._2 + a._2 > 10) ((b._1 + b._2 + a._2) % 10 :: a._1,
    (b._1 + b._2 + a._2) / 10)
  else  (b._1 + b._2 + a._2 :: a._1, 0)
})

if(res._2 == 0) res._1.reverse else res._1 :+ res._2

List(1,2,3).sorted.reverse.zipWithIndex.foldLeft(0D)((a,b) => {
  a  + b._1 * Math.pow(2, b._2)}).toLong