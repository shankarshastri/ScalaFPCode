/**
  * @author ShankarShastri
  *         Algorithm: AkkaServer
  */

package akka.akka_http.Websocket

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{HttpApp, Route}

// Server definition
object WebServer extends HttpApp {
  override def routes: Route =
    path("hello") {
      get {
        Thread.sleep(60000)
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }
}


object AkkaServer extends App {
  WebServer.startServer("localhost", 8080)
}

