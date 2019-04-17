/**
  * @author ShankarShastri
  *         Algorithm: WebsocketLoadTest
  */

package gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

//  ws://demos.kaazing.com/echo
  
  val httpProtocol = http
    .baseUrl("http://demos.kaazing.com")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Gatling2")
    .wsBaseUrl("ws://demos.kaazing.com")
  
  
  val scn = scenario("WS Test")
    .exec(ws("Connect WS").connect("/echo"))
    .exec(ws("Sending Message").sendText("Hello"))
    .exec(ws("Closing WS").close)
  
  
  setUp(
    scn.inject(
      nothingFor(4 seconds), // 1
      atOnceUsers(10), // 2
      rampUsers(10) during (5 seconds), // 3
//      constantUsersPerSec(20) during (15 seconds), // 4
//      constantUsersPerSec(20) during (15 seconds) randomized, // 5
//      rampUsersPerSec(10) to 20 during (10 minutes), // 6
//      rampUsersPerSec(10) to 20 during (10 minutes) randomized, // 7
//      heavisideUsers(1000) during (20 seconds) // 8
    ).protocols(httpProtocol)).maxDuration(2 minutes)
}