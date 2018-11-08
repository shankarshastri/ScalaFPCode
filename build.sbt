name := "ScalaFPCode"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-stream" % "2.5.17",
    "com.typesafe.akka" %% "akka-actor" % "2.5.17",
    "com.typesafe.akka" %% "akka-http" % "10.1.5",
    "io.reactivex" %% "rxscala" % "latest.milestone",
    "org.typelevel" %% "cats-core" % "1.4.0",
    "io.spray" % "spray-json_2.12" % "1.3.5",
    "com.typesafe.akka" %% "akka-http-testkit" % "10.1.5" % Test
  )
}

