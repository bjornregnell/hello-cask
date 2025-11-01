//> using scala 3.7.3
//> using dep com.lihaoyi::cask:0.11.3

object MinimalApplication extends cask.MainRoutes{
  @cask.get("/")
  def hello() = {
    println("/ requested -- serving hello world")
    "Hello World!"
  }

  @cask.post("/do-thing")
  def doThing(request: cask.Request) = {
    val response = request.text().reverse
    println(s"/$request POST requested-- serving reversed: $response")
    response
  }

  initialize()
  println("hello-cask is running at http://localhost:8080")
  println("""try "curl -d 'some data' http://localhost:8080/do-thing" """)
}