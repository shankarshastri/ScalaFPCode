name := "ScalaFPCode"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-stream" % "latest.milestone",
    "com.typesafe.akka" %% "akka-actor" % "latest.milestone",
    "com.typesafe.akka" %% "akka-http" % "latest.milestone",
    "io.reactivex" %% "rxscala" % "latest.milestone",
    "com.typesafe.akka" %% "akka-http-testkit" % "latest.milestone" % Test
  )
}

