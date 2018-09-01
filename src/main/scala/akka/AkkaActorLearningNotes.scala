/**
  * @author ShankarShastri
  *         Algorithm: AkkaActorLearningNotes
  */

package akka

import scala.io.StdIn._
import scala.annotation.tailrec

object AkkaActorLearningNotes {
  def main(args: Array[String]): Unit = {
    
    
    // Send Actor Messages
    // 1) ! => Tell
    // 2) ? => Ask => Returns a Future
    // Prefer To Use Actor Tell Always
    
    // Ask => Send-Recieve => pipeTo(Registers a onComplete Handler
    // Ask operation on sending sender ! msg => It will create a internal actor and thereby requires timeout.
    // So with timeout, it will cleanup the necessary resources.
    // Akka Actors In Case Of Exception Need To Handle The Exception and then return
    // back with akka.actor.Status.Failure for exception passing down to sender. (akka.actor.Status are the only messages treated well by the actors during ask)
    //
    // Forward Message => Akka Message Can Be Forwarded to another actor using (target forward message) => target is a actor ref
    // Recieve Method => type Receive = PartialFunction[Any, Unit]
    // Reply to messages => Sender ! msg
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    // f
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    // )
  }
}
