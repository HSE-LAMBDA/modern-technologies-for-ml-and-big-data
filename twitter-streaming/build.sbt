/** Twitter-streaming example **/

name := "twitter-streaming"

version := "0.0.1"

scalaVersion := "2.10.6"

organization := "ru.hse.modern.technologies"

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
  }
}

target in assembly := file("./assembly/")

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.2" % "provided"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.5.2" % "provided"

libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.10" % "1.5.2"

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "3.0.3"

libraryDependencies += "org.twitter4j" % "twitter4j" % "3.0.3"

libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "3.0.3"

libraryDependencies += "org.twitter4j" % "twitter4j-async" % "3.0.3"

libraryDependencies += "com.twitter" %% "algebird-core" % "0.9.0"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"