

//object Solution {
//  def sumSubarrayMins(A: Array[Int]): Int = {
//    val bigIntA = A.map(BigInt(_))
//    val res =  for {
//      i <-  bigIntA.indices
//    } yield {
//      (i+1 until bigIntA.length).scanLeft(bigIntA(i))((a,b) => a.min(bigIntA(b))).sum
//    }
//    ((res.sum) % BigInt(1000000007)).toInt
//  }
//}
//
//val list = List[BigInt](3,1,2,4)
//
//def sumSubarrayMins(A: Array[Int]): Int = {
//  val bigIntA = A.map(BigInt(_))
//  val res =  for {
//    i <-  bigIntA.indices
//  } yield {
//    val x = (i+1 until bigIntA.length).scanLeft(bigIntA(i))((a,b) => {
//      val a1 = a.min(bigIntA(b))
//      println(a1)
//      a1
//    })
//    println(x)
//    x.sum
//  }
//  ((res.sum) % BigInt(1000000007)).toInt
//}
//
//sumSubarrayMins(list.toArray.map(_.toInt))


//
val l = List[BigInt](3,3,3,1,2,1,1,2,3,3,4)
//class Solution {
//  public int totalFruit(int[] tree) {
//    int ans = 0, i = 0;
//    Counter count = new Counter();
//    for (int j = 0; j < tree.length; ++j) {
//      count.add(tree[j], 1);
//      while (count.size() >= 3) {
//        count.add(tree[i], -1);
//        if (count.get(tree[i]) == 0)
//          count.remove(tree[i]);
//        i++;
//      }
//
//      ans = Math.max(ans, j - i + 1);
//    }
//
//    return ans;
//  }
//}


def totalFruits(tree: List[BigInt]) = {
  
  def mapAdd(e: BigInt, m: Map[BigInt, BigInt], value: BigInt): Map[BigInt, BigInt] = {
    val updateValue = m(e) + value
    if(updateValue == 0) {
      m.filterKeys(_ != e).withDefaultValue(0)
    }
    else m.updated(e, updateValue)
  }
  
  def totalFruitsHelper(countMap: Map[BigInt, BigInt]
                        = Map[BigInt, BigInt]().withDefaultValue(0),
                        ans: BigInt = 0,
                        index: BigInt = 0,
                        jthIndex: BigInt = 0): BigInt = {
   
    (jthIndex >= tree.length) match {
      case true => ans.max(jthIndex - index + 1)
      case _ =>
        (countMap.size) match {
        case n if n >=3 =>
          val updateMap  = mapAdd(l(index.toInt), countMap, -1)
          totalFruitsHelper(updateMap, ans.max(jthIndex - index), index+1, jthIndex)
        case _ =>
          totalFruitsHelper(mapAdd(l(jthIndex.toInt), countMap, 1), ans.max(jthIndex - index), index, jthIndex+1)
      }
    }
  }
  totalFruitsHelper()
}


totalFruits(l)
//val l = List[BigInt](3,3,3,1,2,1,1,2,3,3,4)