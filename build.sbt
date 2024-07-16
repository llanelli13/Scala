lazy val root = (project in file("."))
  .aggregate(core, app)
  .settings(
    name := "my-graph-project",
    version := "0.1.0",
    scalaVersion := "3.2.0",
    publishArtifact := false
  )

lazy val core = (project in file("core"))
  .settings(
    name := "core",
    scalaVersion := "3.2.0",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test
    )
  )

lazy val app = (project in file("app"))
  .dependsOn(core)
  .settings(
    name := "app",
    scalaVersion := "3.2.0",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.0.0"
    )
  )
