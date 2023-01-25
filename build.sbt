ThisBuild / scalaVersion := "2.12.2"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """Test_App_Play""",
    libraryDependencies ++= Seq(
      guice
    )
  )