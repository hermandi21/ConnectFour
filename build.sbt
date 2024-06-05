val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "VierGewinnt",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % Test,
    libraryDependencies += "org.scalafx" %% "scalafx" % "16.0.0-R24",
    libraryDependencies += "com.oracle.database.jdbc" % "ojdbc8" % "19.8.0.0",
    libraryDependencies += "net.codingwell" %% "scala-guice" % "7.0.0",
    libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.3",
    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.2.0",
    libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.3",
    libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.34.0",
    libraryDependencies += "org.scalatestplus" %% "mockito-3-4" % "3.2.10.0" % Test,
    scalaVersion := "2.13.8"

    libraryDependencies ++= Seq(
      "org.openjfx" % "javafx-base" % "22" classifier "linux",
      "org.openjfx" % "javafx-controls" % "22" classifier "linux",
      "org.openjfx" % "javafx-fxml" % "22" classifier "linux",
      "org.openjfx" % "javafx-graphics" % "22" classifier "linux"
    )

    javaOptions ++= Seq(
      "--module-path", "/usr/lib/jvm/javafx-sdk-22/lib",
      "--add-modules", "javafx.controls,javafx.fxml"
    ),
    unmanagedResourceDirectories in Compile += baseDirectory.value / "src" / "main" / "scala",
  )