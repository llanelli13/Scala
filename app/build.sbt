name := "app"

scalaVersion := "3.2.0"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.0"
)

dependsOn(core)
