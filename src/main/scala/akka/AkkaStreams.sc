import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.actor.ActorPublisherMessage.Request
import akka.stream.scaladsl.{Keep, RunnableGraph, Sink, Source}

import scala.concurrent.Future
implicit val system = ActorSystem("ExampleSystem")

implicit val mat = ActorMaterializer() // created from `system`
val source = Source(1 to 10)
val sink = Sink.fold[Int, Int](0)(_ + _)



val sum: Future[Int] = source.runWith(sink)
