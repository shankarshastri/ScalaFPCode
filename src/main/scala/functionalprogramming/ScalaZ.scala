package functionalprogramming

import scalaz.zio._


object ScalaZ extends scala.App {

  val k = for {
    iFiber <- IO.effect(10).fork
    res <- iFiber.join
  } yield res
}
