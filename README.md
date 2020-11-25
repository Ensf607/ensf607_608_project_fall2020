# Classic ToolShop Desktop App with API
This is a joint, cross-course project with ENSF 607/608. It is a classic Tool Shop desktop application written in Java. 

## Contributors

Ziad Chemali, Stan Chen

## Architecture

![image-20201125012932150](README.assets/image-20201125012932150.png)

## Testing

Jenkins were introduced as a tool to help with the deployment/testing purposes. Script used for compiling and running the backend server in Jenkins build execute shell: 

```shell
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







## Develop setup

1. this is classic java project. `jars/mysql-connector-java-8.0.22.jar` needs to be added to class path. 
2. Alternatively, if using maven, just use pom.xml to fullfil the dependencies. 
