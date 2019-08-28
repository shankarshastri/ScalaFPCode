package scalaz

import scalaz.UnderstandFiber.{TreeType, constructTree}
import scalaz.zio._
import scalaz.zio.console._
import zio.{App, Task, UIO}

import scala.annotation.tailrec
import scala.util.Random


object UnderstandFiber extends App {

  def errL = throw new Exception("JHel")

  implicit class zioToInt[-R, +E, +A](z: ZIO[R, E, A]) {
    def r = z.fold(err => {
      unsafeRun(putStrLn(err.toString))
      1
    }, _ => 0)
  }
  def fib(n: BigInt): UIO[BigInt] =
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

  @tailrec
  def fibI(i: BigInt, a: BigInt = 0, b: BigInt = 1): BigInt = {
    if (i == 0) a
    else if (i == 1) b
    else fibI(i - 1, b, a + b)
  }

  def compute = {
    (for {
      i <- getStrLn.map(e => BigInt(e))
      res <- IO.effectTotal(fibI(i)).fork
      r1 <- res.join
      _ <- putStrLn(r1.toString)
      res1 <- fib(i)
      _ <- putStrLn(res1.toString)
    } yield ()).r
  }

  def computeRace = {
    (for {
      i <- IO.effect(fibI(4)).fork
      j <- IO.effect(fibI(1)).fork
      res <- i.join.race(j.join)
      _ <- putStrLn(res.toString).r
    } yield res).r
  }

  def threadBlockAndPrint(i: Int) = {
    IO.effect {
      unsafeRun(IO.effect(Thread.sleep(10000)))
      unsafeRun(putStrLn("Hello"))
    }
  }

  sealed trait TreeType[+T]
  final case class LeafNode[T](d: T) extends TreeType[T]
  final case class IntNode[T](d: T, l: List[TreeType[T]]) extends TreeType[T]

  def constructTree[T](level: Int, nON: Int, rootNode: UIO[TreeType[T]])
                      (d: () => T, g: (() => T, Boolean) => UIO[TreeType[T]]): UIO[TreeType[T]] = {
    def constructTreeHelper(level: Int, nON: Int, t: UIO[TreeType[T]]): UIO[TreeType[T]] = {
      t.flatMap {
        case e: LeafNode[T] => UIO.succeedLazy(e)
        case e: IntNode[T] =>
          level match {
            case 1 =>
              ZIO.collectAllPar((1 to nON).par
                .map(_ => constructTreeHelper(level - 1, nON, g(d, false))).toList)
                .map(res12 => e.copy(l = res12))

            case _ =>
              ZIO.collectAllPar((1 to nON).par
                .map(_ => constructTreeHelper(level - 1, nON, g(d, true))).toList)
                .map(res12 => e.copy(l = res12))
          }
      }
    }
    constructTreeHelper(level, nON, rootNode)
  }


  override def run(args: List[String]) = {
    (for {
      r <- constructTree(10, 100, UIO.succeedLazy(IntNode(10, List.empty[TreeType[Int]])))(Random.nextInt , (d, f) => {
      if(f) UIO.succeedLazy(IntNode(d(), List.empty[TreeType[Int]])) else UIO.succeedLazy(LeafNode(d()))})
      _ <- putStrLn(r.toString)
    } yield ()).r
  }
}
