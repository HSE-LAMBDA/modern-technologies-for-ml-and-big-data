/** Twitter-streaming example **/

import sbt._

lazy val commonSettings = Seq(
  name := "twitter-streaming",
  version := "0.0.1",
  organization := "ru.hse.modern.technologies",
  scalaVersion := "2.10.6"
)

lazy val scalacSettings = Seq(
  scalacOptions += "-feature",
  scalacOptions += "-deprecation",
  scalacOptions += "-unchecked",
  retrieveManaged := true
)

val dependencies = Seq(
  /** Spark */
  "org.apache.spark" %% "spark-core" % "1.5.1" % "provided",
  "org.apache.spark" %% "spark-streaming" % "1.5.1" % "provided",
  "org.apache.spark" %% "spark-streaming-twitter" % "1.5.1" % "provided",
  "org.apache.spark" %% "spark-mllib" % "1.5.1" % "provided"
)

lazy val assemblySettings = Seq(
  target in assembly := file("./assembly/"),
  test in assembly := {},
  assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
  assemblyMergeStrategy in assembly := {
    case PathList(ps @ _*) if ps contains "META-INF" => MergeStrategy.discard
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  }
)


lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(scalacSettings: _*).
  settings(assemblySettings: _*).
  settings(resolvers ++= Seq(
    "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
    "Akka Repository" at "http://repo.akka.io/releases/",
    "gphat" at "https://raw.github.com/gphat/mvn-repo/master/releases"
  )).
  settings(libraryDependencies ++= dependencies)

