//> using scala 3.7.3
//> using dep com.lihaoyi::cask:0.11.3
//> using dep com.lihaoyi::scalatags:0.13.1

import scalatags.Text.all._

object MinimalApplication extends cask.MainRoutes:
  @cask.get("/")
  def hello() = 
    println("/ requested -- serving hello world")
    doctype("html"):
      html:
        body(
          h1("Hello World"),
          p("I am cow")
        )
  end hello
  
  @cask.post("/do-thing")
  def doThing(request: cask.Request) = 
    val response = request.text().reverse
    println(s"/$request POST requested-- serving reversed: $response")
    response
  end doThing

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  initialize()
  println(s"hello-cask is running at ${host}:$port")
  println(s"""try "curl -d 'some data' http://localhost:$port/do-thing" """)
end MinimalApplication