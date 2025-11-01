//> using scala 3.7.3
//> using dep com.lihaoyi::cask:0.11.3

object MinimalApplication extends cask.MainRoutes{
  @cask.get("/")
  def hello() = {
    "Hello World!"
  }

  @cask.post("/do-thing")
  def doThing(request: cask.Request) = {
    request.text().reverse
  }

  initialize()
  println("hello-cask is running at http://localhost:8080")
}