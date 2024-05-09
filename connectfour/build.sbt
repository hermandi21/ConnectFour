val scala3Version = "3.4.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "connectfour",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test",
    libraryDependencies += "org.scoverage" % "sbt-jacoco" % "2.17.1" % "test"
  )

  .enablePlugins(JacocoCoverallsPlugin)