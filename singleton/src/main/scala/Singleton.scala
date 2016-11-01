object Singleton {

  object NetworkService {

    case class Request(path: String)

    var activeRequests: Map[Request, String] = Map()

    def doRequest(path: String) = { activeRequests += (Request(path = path) -> "new") }

  }

  def main(args: Array[String]): Unit = {
    NetworkService.doRequest("/users")
    println(NetworkService.activeRequests.mkString)
  }

}
