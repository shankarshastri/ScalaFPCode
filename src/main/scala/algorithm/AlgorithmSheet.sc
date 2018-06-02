//val l = List(3,2,3, 4).toArray
val sum = 7
val l1 = List(3, 2, 4)
//
//  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
//    nums.toList.zipWithIndex.sliding(2).toList.filter(x => {
//      sumFromListOfTuples(x) == sum
//    }).flatten.map(_._2).toArray
//  }
//l.toList.zipWithIndex.sliding(2).toList
//twoSum(l, sum)

//
//
def sumFromListOfTuples(list: List[(Int, Int)]): Int = {
  list.map(_._1).sum
}
l1

def powerSet[A](xs: List[A]): List[List[A]] =
  xs.foldLeft(List(Nil: List[A]))((accum, elem) => accum.flatMap(l => Seq(l, elem :: l)))

def powerSetWithIndex[A](xs: List[(A, Int)]): List[List[(A, Int)]] = {
  xs.foldLeft(List(Nil: List[(A, Int)]))((accum, elem) => {
    accum.flatMap(l => Seq(l, elem :: l))
  })
}

powerSetWithIndex(l1.zipWithIndex)
  .filter(x => {
    sumFromListOfTuples(x) == sum && x.length == 2
  }).flatten.map(_._2).reverse


//

def twoSum(nums: Array[Int], target: Int): Array[Int] = {
  var flag = true
  val vec = for {
    i <- 0 until nums.length
    j <- 0 until nums.length
    if (nums(i) + nums(j) == target) && (i != j) && (flag == true)
  } yield {
    flag = false
    (i, j)
  }
  Array(vec.head._1, vec.head._2)
}

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    powerSetWithIndex(nums.toList.zipWithIndex)
      .filter(x => {
        sumFromListOfTuples(x) == target && x.length == 2
      }).flatten.map(_._2).reverse.toArray
  }

  def sumFromListOfTuples(list: List[(Int, Int)]): Int = {
    list.map(_._1).sum
  }

  def powerSetWithIndex[A](xs: List[(A, Int)]): List[List[(A, Int)]] = {
    xs.foldLeft(List(Nil: List[(A, Int)]))((accum, elem) => {
      accum.flatMap(l => Seq(l, elem :: l))
    })
  }
}

object Solution1 {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val vec = for {
      i <- 0 until nums.length
      j <- 0 until nums.length
      if (nums(i) + nums(j) == sum)
    } yield (i, j)
    Array(vec.head._1, vec.head._2)
  }

}

twoSum(l1.toArray, sum)