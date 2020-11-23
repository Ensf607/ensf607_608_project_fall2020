Add this file to the build path, go to docs/setup_mysql.md for setup notes
https://stackoverflow.com/questions/4955635/how-to-add-local-jar-files-to-a-maven-project

mvn install:install-file \
   -Dfile=jars/mysql-connector-java-8.0.22.jar \
   -DgroupId=com.mysql.jdbc.Driver \
   -DartifactId=mysql \
   -Dversion=8.0.22 \
   -Dpackaging=jar \
   -DgeneratePom=true
   
   

/home/ubuntu/.m2/repository/com/mysql/jdbc/Driver/mysql/8.0.22/


### build path mod
https://stackoverflow.com/questions/8084926/including-jar-files-in-class-path
https://howtodoinjava.com/java/basics/java-classpath/



### proper maven calling signature

```
# export CLASSPATH=jars/*.jar
mvn -v
echo "building maven package"
mvn clean install -U
mvn clean package
echo "initing server"
echo "building maven package"
mvn package
echo "initing server"
mvn exec:java -Dexec.mainClass="server.controller.ServerController" -Dexec.classpathScope=runtime 
```
https://blog.csdn.net/qbg19881206/article/details/19850857