# Classic ToolShop Desktop App with API
This is a joint, cross-course project with ENSF 607/608. It is a classic Tool Shop desktop application written in Java. 

## Contributors

Ziad Chemali, Stan Chen

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
3.  
