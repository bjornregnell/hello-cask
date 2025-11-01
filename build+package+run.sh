mkdir -p target
scala --power package hello-cask.scala -f -o target/hello-cask.jar --assembly --preamble=false
java -jar target/hello-cask.jar
