// build.sbt
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "FunctionalProgramming",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.10" % Test,
      "dev.zio" %% "zio" % "2.0.0",
      "dev.zio" %% "zio-json" % "0.3.0",
      "dev.zio" %% "zio-nio" % "2.0.0"
    ).map(_.exclude("org.scala-lang.modules", "scala-collection-compat_2.13"))
  )
