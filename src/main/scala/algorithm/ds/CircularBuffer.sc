import scalaz.zio._

class GParent
class Parent extends GParent
class Child extends Parent


class Box[+A]

class Box2[-A]

def foo(x : Box[Parent]) : Box[Parent] = identity(x)

def bar(x : Box2[Parent]) : Box2[Parent] = identity(x)

foo(new Box[Child]) // success

//foo(new Box[GParent]) // type error

//bar(new Box2[Child]) // type error

bar(new Box2[GParent]) // success


def k[A <: Parent](a: A): A = identity(a)
def fib(n: Int): UIO[Int] =
  if (n <= 1) {
    IO.succeedLazy(1)
  } else {
    for {
      fiber1 <- fib(n - 2).fork
      fiber2 <- fib(n - 1).fork
      v2     <- fiber2.join
      v1     <- fiber1.join
    } yield v1 + v2
  }