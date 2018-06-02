val res = multiply(6, 6, 6, 6)

def multiply(x: BigInt, y: BigInt, xCount: BigInt, yCount: BigInt) = {

  def helper(x: BigInt, y: BigInt, countX: BigInt = 0, countY: BigInt = 0): (BigInt, BigInt) = {
    if (countX != xCount && countY == yCount) (x * x, y)
    else if (countX == xCount && countY != yCount) (x, y * y)
    else {
      println(x)
      if (countX != xCount && countY != yCount)
        helper(x * x, y * y, countX + 1, countY + 1)
      else if (countX != xCount)
        helper(x * x, y, countX + 1, countY)
      else helper(x, y * y, countX, countY + 1)
    }
  }

  helper(x, y)
}
res._1 == res._2


Math.log(X)