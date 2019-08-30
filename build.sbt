name := "ScalaFPCode"

version := "0.1"

enablePlugins(GatlingPlugin)
enablePlugins(JmhPlugin)


scalaVersion := "2.12.8"
scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-stream" % "2.5.25",
    "com.typesafe.akka" %% "akka-actor" % "2.5.25",
    "com.typesafe.akka" %% "akka-http" % "10.1.9",
    "io.reactivex" %% "rxscala" % "0.26.5",
    "org.typelevel" %% "cats-core" % "1.6.1",
    "io.spray" % "spray-json_2.12" % "1.3.5",
    "com.google.guava" % "guava" % "28.1-jre",
    "com.typesafe.akka" %% "akka-http-testkit" % "10.1.9" % Test,
    "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
    "org.scalactic" %% "scalactic" % "3.0.8" % Test,
    "org.scalatest" %% "scalatest" % "3.0.8" % Test,
    "org.scalaz" %% "scalaz-zio" % "1.0-RC5",
    "org.scalaz" %% "scalaz-core" % "7.2.28",
    "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided",
    "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.2.1" % "test,it",
    "io.gatling"            % "gatling-test-framework"    % "3.2.1" % "test,it",
    "com.github.tototoshi" %% "scala-csv" % "1.3.6",
    "com.nrinaudo" %% "kantan.csv-generic" % "0.5.1",
    "com.github.melrief" %% "purecsv" % "0.1.1"
  )
}

