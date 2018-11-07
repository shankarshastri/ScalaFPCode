name := "ScalaFPCode"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-stream" % "2.5.17",
    "com.typesafe.akka" %% "akka-actor" % "2.5.17",
    "com.typesafe.akka" %% "akka-http" % "2.5.17",
    "io.reactivex" %% "rxscala" % "latest.milestone",
    "org.typelevel" %% "cats-core" % "1.4.0",
    "io.spray" % "spray-json_2.12" % "1.3.4",
    "com.typesafe.akka" %% "akka-http-testkit" % "2.5.17" % Test
  )
}

