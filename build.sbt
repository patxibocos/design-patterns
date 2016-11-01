import sbt._
import Keys._

lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
    "org.scalactic" %% "scalactic" % "3.0.0",
    "org.scalatest" %% "scalatest" % "3.0.0" % "test",
    "org.mockito" % "mockito-core" % "2.2.5"
  )
)

lazy val strategy = project.
  settings(commonSettings: _*)

lazy val observer = project.
  settings(commonSettings: _*)

lazy val decorator = project.
  settings(commonSettings: _*)

lazy val factory = project.
  settings(commonSettings: _*)

lazy val singleton = project.
  settings(commonSettings: _*)