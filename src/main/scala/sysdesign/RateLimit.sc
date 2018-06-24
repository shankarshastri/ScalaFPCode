case class Request(ip: String)
case class ClearRateLimit(ip: String)

val x: PartialFunction[Any, String] = {
  case msg: Request => {
    println("COming")
    msg.ip
  }
  case msg: ClearRateLimit => msg.ip
}


x(Request("SSSS"))