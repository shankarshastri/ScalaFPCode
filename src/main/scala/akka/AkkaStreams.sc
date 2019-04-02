import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, OverflowStrategy}
import akka.stream.scaladsl.{Flow, GraphDSL, Keep, RunnableGraph, Sink, Source}

import scala.concurrent.Future
implicit val system = ActorSystem("ExampleSystem")

implicit val mat = ActorMaterializer() // created from `system`
val source = Source(1 to 10)
val sink:Sink[Int, Future[Int]] = Sink.fold(0)(_ + _)

val sumToNat = source.toMat(sink)(Keep.right)


val sum: Future[Int] = source.runWith(sink)
val s = sumToNat.run()


implicit val ec = system.dispatcher
val r  = Source(List(1,2,3,4)).mapAsyncUnordered(10)(e => Future(e * 1))
  .buffer(Int.MaxValue, OverflowStrategy.backpressure)
  .toMat(Sink.seq)(Keep.right)
val s1 = r.run()

val k1, k2 = 10
k1
k2

def flow[T] = Flow[T].map(_.toString)

Source(List(1,2,3,4)).via(flow)

while(!sum.isCompleted && !s.isCompleted && !s1.isCompleted) {}
sum
s
s1
