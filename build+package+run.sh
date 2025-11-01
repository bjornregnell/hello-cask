mkdir -p target
scala-cli --power package hello-cask.scala -f -o target/hello-cask --assembly
./hello-cask