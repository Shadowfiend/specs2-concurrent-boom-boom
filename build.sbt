organization := "com.elemica"

name         := "specs2-concurrent-boom-boom"

version      := "0.0.1"

scalaVersion := "2.11.8"

scalacOptions           ++= DefaultOptions.scalac

lazy val project1 =
  Project("project1", file("project1"))
    .settings(
      scalaVersion := "2.11.8",
      libraryDependencies ++= testLibraries,
      scalacOptions in Test ++= Seq("-Yrangepos")
    )

lazy val project2 =
  Project("project2", file("project2"))
    .settings(
      scalaVersion := "2.11.8",
      libraryDependencies ++= testLibraries,
      scalacOptions in Test ++= Seq("-Yrangepos")
    )

val testLibraries = Seq(
  "org.specs2" %% "specs2-core" % "3.8.8" % "test"
)
