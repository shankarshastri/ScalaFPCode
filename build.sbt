name := "ScalaFPCode"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-stream" % "2.5.20",
    "com.typesafe.akka" %% "akka-actor" % "2.5.20",
    "com.typesafe.akka" %% "akka-http" % "10.1.7",
    "io.reactivex" %% "rxscala" % "0.26.5",
    "org.typelevel" %% "cats-core" % "1.6.0",
    "io.spray" % "spray-json_2.12" % "1.3.5",
    "com.google.guava" % "guava" % "27.1-jre",
    "com.typesafe.akka" %% "akka-http-testkit" % "10.1.7" % Test,
    "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
    "org.scalactic" %% "scalactic" % "3.0.5" % Test,
    "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )
}

