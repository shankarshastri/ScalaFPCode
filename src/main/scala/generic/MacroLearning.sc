import zio._
import zio.clock._
import zio.blocking._
val runtime = new DefaultRuntime {}




val k = effectBlocking(Thread.sleep(Long.MaxValue))
