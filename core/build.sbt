lazy val commonSettings = Seq(
  scalaVersion := "2.12.18", // Remplacez par votre version de Scala
  libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % "2.0.0",
    "dev.zio" %% "zio-json" % "0.2.0",
    "org.scalatest" %% "scalatest" % "3.2.9" % Test
  )
)

lazy val core = (project in file("core"))
  .settings(
    name := "core",
    commonSettings
  )

lazy val app = (project in file("app"))
  .settings(
    name := "app",
    commonSettings
  )
  .dependsOn(core)

lazy val root = (project in file("."))
  .aggregate(core, app)
  .settings(
    name := "root",
    commonSettings
  )
