
import java.util.concurrent.atomic.AtomicInteger

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureMutex extends App {
    var x = new AtomicInteger(100)
    Future {
      x.updateAndGet((_ : Int) => 101)
    }
  println(x)
  Future {
    x.updateAndGet((_ : Int) => 102)
  }
  Thread.sleep(1000)
  println(x)
}
