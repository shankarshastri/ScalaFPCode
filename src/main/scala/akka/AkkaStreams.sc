import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.actor.ActorPublisherMessage.Request
import akka.stream.scaladsl.{Keep, RunnableGraph, Sink, Source}

import scala.concurrent.Future
implicit val system = ActorSystem("ExampleSystem")

implicit val mat = ActorMaterializer() // created from `system`
val source = Source(1 to 10)
val sink:Sink[Int, Future[Int]] = Sink.fold(0)(_ + _)

val sumToNat = source.toMat(sink)(Keep.right)


val sum: Future[Int] = source.runWith(sink)
val s = sumToNat.run()
while(!sum.isCompleted && !s.isCompleted) {}
sum
s
