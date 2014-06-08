name := "UniPlex"

version := "0.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "mysql" % "mysql-connector-java" % "5.1.28",
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  cache
)     

play.Project.playJavaSettings
