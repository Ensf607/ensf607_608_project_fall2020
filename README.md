# Classic ToolShop Desktop App with API
This is a joint, cross-course project with ENSF 607/608. It is a classic Tool Shop desktop application written in Java. 

## Contributors

Ziad Chemali, Stan Chen



## Quick Start

#### client and remote server

1. fulfill dependencies in `pom.xml` if builds are missing packages
2. making sure remote backend server is up and running. (See note below)
3. to connect to the remote client, compile and run `src/client/main.java`

#### client and local server

1. fulfill dependencies in `pom.xml` if builds are missing packages
2. to start the server, compile and run `src/server/startServerLocal.java` (See note below)
3. to start the local client, compile and run `src/client/mainLocal.java` 



## Summary

Inventory management system that has two functionalities:

- Allows owner to add new customers/update their information and allows customers to search for tools from the data base and purchase.
- If the quantity of an item goes below 40 items then the program automatically generates an order line for that item



## Architecture

![image-20201125012932150](README.assets/image-20201125012932150.png)

## Front-End

The front end is a GUI application that will send messages in a JSON format to the server via sockets, then it will receive a response. Example if search by ToolId is selected  a we are searching for a ToolID of 8000 then it will send a JSON message as follow:  ```"{ \"type\" : \"GET\", \"table\" : \"TOOL\" , \"scope\":\"select\",\"field\":\"ToolID\",\"field_value\":\"8000\"}";```

The response is a JSON Node as follows ```[ {  "ToolID" : 8000,  "Name" : "Knock Bitzzz",  "Type" : "Electric",  "Quantity" : 70,  "Price" : 15.0,  "SupplierID" : 8004,  "PowerType" : null} ]```

 And it will be printed in the GUI

#### GUI Panels

**1. Inventory Panel **

![image-20201126164305536](README.assets/image-20201126164305536.png)

**Note**: If you press <u>List All Tools</u> or <u>Search</u> (with correct ToolID or Tool Name) the following table is generated



![image-20201126164637706](README.assets/image-20201126164637706.png)

**2. Purchase Panel **

After selecting a row from the table, purchase panel will appear

![image-20201126164933543](README.assets/image-20201126164933543.png)



if the customer ID/First Name are correct then purchase will be generated and the following pop-up will appear

![image-20201126165135578](README.assets/image-20201126165135578.png)

else this pop-up will appear

![image-20201126165210768](README.assets/image-20201126165210768.png)

**3. CMS Panel **

press on ClientGUI option from the menu bar, it will direct you to a Login panel

![image-20201126165405718](README.assets/image-20201126165405718.png)

If username/password are correct then the client management panel will show

![image-20201126165733392](README.assets/image-20201126165733392.png)

**Updating/Deleting a customer**

First search for a customer then select the customer from the JList. After selecting a row, the Client Information in the right side will be populated automatically

![image-20201126170102245](README.assets/image-20201126170102245.png)



**Adding new customer **

Simply fill in all the fields required, and click Add New Customer. Note: a unique client Id will be generated

![image-20201126170541453](README.assets/image-20201126170541453.png)



Double check by searching for the newly added customer

![image-20201126170658350](README.assets/image-20201126170658350.png)

Customer successfully added



## Back-End

### How to start local backend server

to start the local backend server, compile and run 

```
src/server/startServerLocal.java
```

if the console prints the following, it means the server is ready. 

![image-20201126175849636](README.assets/image-20201126175849636.png)

### How to start remote backend server

Note: For temporary demo purpose, Prof & TA can access:  

**Our jenkins build server http://54.185.156.100:8080/**

**username: `ensf`  **

**password: `ensf607`**



If server is not running, build the job "Final Project Demo" to start the backend server. 

![image-20201126175328739](README.assets/image-20201126175328739.png)

click into the project

![image-20201126175953375](README.assets/image-20201126175953375.png)

In this job page, click `Console Output`, 

![image-20201126180322322](README.assets/image-20201126180322322.png)

If the end of the console log prints the logs as above, this means the server is ready to serve. 



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
