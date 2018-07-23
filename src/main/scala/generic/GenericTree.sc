sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]



List(1,2,3).fold(0)((a,b) => a+b)





def maximiumInTree(x: Tree[Int]): Int = {
  x match {
    case Leaf(x) => x
    case Branch(l, r) =>
      val x = maximiumInTree(l)
      val y = maximiumInTree(r)
      x max y
  }
}

def depth(x: Tree[Int]): Int = {
  x match {
    case Leaf(_) => 0
    case Branch(l,r) => 1 + depth(l) max depth(r)
  }
}

def fold[T, T1](x: Tree[T], z: T1)(op: (T, T1) => T1):T1 = {
  x match {
    case Leaf(l) => op(z, l)
    case Branch(l,r) => op(fold(l, z)(op), fold(r,z)(op))
  }
}

def maximiumViaFold(x: Tree[Int]) = {
  fold(x, 0)(_ max _)
}


def mapTree[T, T1](x: Tree[T])(f: T => T1): Tree[T1] = {
  x match {
    case Leaf(x) => Leaf(f(x))
    case Branch(l, r) => Branch(mapTree(l)(f), mapTree(r)(f))
  }
}

