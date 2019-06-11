name := "ScalaFPCode"

version := "0.1"

enablePlugins(GatlingPlugin)

scalaVersion := "2.12.8"
scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-stream" % "2.5.23",
    "com.typesafe.akka" %% "akka-actor" % "2.5.23",
    "com.typesafe.akka" %% "akka-http" % "10.1.7",
    "io.reactivex" %% "rxscala" % "0.26.5",
    "org.typelevel" %% "cats-core" % "1.6.1",
    "io.spray" % "spray-json_2.12" % "1.3.5",
    "com.google.guava" % "guava" % "27.1-jre",
    "com.typesafe.akka" %% "akka-http-testkit" % "10.1.7" % Test,
    "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
    "org.scalactic" %% "scalactic" % "3.0.7" % Test,
    "org.scalatest" %% "scalatest" % "3.0.8" % Test,
    "org.scalaz" %% "scalaz-zio" % "1.0-RC5",
    "org.scalaz" %% "scalaz-core" % "7.2.27",
    "com.softwaremill.macwire" %% "macros" % "2.3.2" % "provided",
    "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.0.3" % "test,it",
    "io.gatling"            % "gatling-test-framework"    % "3.0.3" % "test,it"
  )
}

