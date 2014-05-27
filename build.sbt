name := "UniPlex"

version := "0.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "mysql" % "mysql-connector-java" % "5.1.28",
  cache
)     

play.Project.playJavaSettings
