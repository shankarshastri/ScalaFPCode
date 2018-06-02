package akka

import akka.actor.ActorSystem
import akka.stream._
import akka.stream.scaladsl._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

object AkkaStreamsLearning extends App {


  implicit val system = ActorSystem("QuickStart")
  implicit val materializer = ActorMaterializer()
  val source = Source(1 to 10)
  val source1 = Source(2 to 200)
  val sink = Sink.fold[Int, Int](0)(_ + _)
  //
  //
  //  println(source)
  //  println(sink)
  //  // connect the Source to the Sink, obtaining a RunnableGraph
  //  val runnable: RunnableGraph[Future[Int]] = source.toMat(sink)(Keep.right)
  //
  //  // materialize the flow and get the value of the FoldSink
  //  val sum: Future[Int] = runnable.run()
  //
  //
  //
  //  sum.onComplete{
  //    case Success(x) => println(x)
  //  }
  //  sum.onComplete{ _ =>
  //    system.terminate
  //  }

  val sum = (source).runWith(sink)

  sum.onComplete {
    case Success(x) => println(x)
  }
  sum.onComplete { _ =>
    system.terminate
  }
}
