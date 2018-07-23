

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}





val x1 = Future {
  Thread.sleep(1000)
  1
}

val x2 = Promise[Int]


val x3 = Future {
  new Exception("Failed")
}
Thread.sleep(6000)
x2.future.map(x => x)


x3.transformWith {
  case Success(x) => Future.successful(x)
  case Failure(x) => Future.failed(x)
}