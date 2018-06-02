import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream._
import akka.stream.scaladsl._

implicit val system = ActorSystem("QuickStart")
implicit val materializer = ActorMaterializer()
val source: Source[Int, NotUsed] = Source(1 to 100)
source.runForeach(i ⇒ println(i))(materializer)
