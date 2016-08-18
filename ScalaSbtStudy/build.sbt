name := "ScalaSbtStudy"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.15"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.15",
  "org.scalatest" % "scalatest_2.10" % "2.2.6" % "test",
  "org.mockito" % "mockito-core" % "1.10.19" % "test",
  "net.liftweb" % "lift-webkit_2.10" % "2.6.3",
  "net.liftweb" % "lift-json_2.10" % "2.6.3",
  "com.google.code.gson" % "gson" % "2.6.2"
)

