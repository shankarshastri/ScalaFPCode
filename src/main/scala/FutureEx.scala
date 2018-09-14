import scala.concurrent.Future
import scala.concurrent.Promise
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}


object FutureEx extends App {
  case class MultiException[T](message: String, l: List[Failure[T]]) extends Exception(message)
val x =   Future {
    List(Try(1),
      Try(throw new Exception("Hello")),
      Try(throw new Exception("Hello1")),
      Try(3))
  }

  val x1 = for {
    res <- x
  } yield {
    val resultOfFailures = res.collect {
      case ex@Failure(_) => ex
    }
    resultOfFailures.length match {
      case 0 => res
      case _ => MultiException("Failed", resultOfFailures)
    }
    resultOfFailures
  }
  println(x1)
  Thread.sleep(1000)
  println(x1)

}
