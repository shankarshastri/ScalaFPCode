


def isPowerOfTwo(x: Int): Boolean = {
  (x != 0) && ((x & x - 1) == 0)
}

//List(3,5,4,7,10,12).filter(isPowerOfTwo(_))

List(3, 5, 4, 7, 10, 12).toSet.subsets(2).filter(x => isPowerOfTwo(Math.abs(x.head - x.last))).toSet