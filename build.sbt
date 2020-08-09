name := """hands-on-scalaz"""

version := "1.0"

scalaVersion := "2.12.12"

scalacOptions += "-Ypartial-unification"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.17"

libraryDependencies += "org.specs2" %% "specs2-core" % "4.10.2" % "test"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.1"
