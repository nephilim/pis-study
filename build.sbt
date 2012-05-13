name := "pis-study"

version := "0.2"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq( 
    "junit" % "junit" % "4.8.1" % "test",
    "org.scalatest" % "scalatest_2.9.2" % "1.7.2" % "test")
    
libraryDependencies += "org.scalatest" % "scalatest_2.9.1" % "1.6.1" % "test"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "6.0.4"