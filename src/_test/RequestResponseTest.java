package _test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import server.controller.Request;

import javax.rmi.CORBA.Util;

import static java.lang.Thread.sleep;

public class RequestResponseTest {
//    public static void main(String[] args) throws JsonProcessingException, InterruptedException {
//        testSelectWhereOrder();
//        sleep(500); // TODO: a manually intoroduced delay is import to eliminate cross firing
//        testSelectWhereClient();
//    }

    @Test
    public static void testSelectWhereOrder() throws JsonProcessingException {
        /**
         * example:
         * { "type": "GET" , "table": "ORDER", "scope":"select" , "field": "OrderID" , "field_value" : "27051"}
         */
        String getSelectTable = "{ \"type\": \"GET\" , \"table\": \"ORDER\", \"scope\":\"select\" , \"field\": \"OrderID\" , \"field_value\" : \"27051\"}";
        testRequest(getSelectTable);
        testSelectWhereClient();

    }

    @Test
    public static void testSelectWhereClient() throws JsonProcessingException {
        /**
         * example:
         * { "type": "GET" , "table": "CLIENT", "scope":"select" , "field": "ClientID" , "field_value" : "10"}
         */
        String getSelectTable = "{ \"type\": \"GET\" , \"table\": \"CLIENT\", \"scope\":\"select\" , \"field\": \"ClientID\" , \"field_value\" : \"10\"}";
        testRequest(getSelectTable);
    }

    @Test
    public static void testFullSelect() throws JsonProcessingException {
        /**
         * example:
         * { "type" : "GET", "table" : "ORDER" , "scope":"all"}
         */
        String getFullTable = "{ \"type\" : \"GET\", \"table\" : \"ORDER\" , \"scope\":\"all\"}";
        testRequest(getFullTable);
    }

    public static void testRequest(String request) throws JsonProcessingException {
        Request r = new Request();
        System.out.println("response is :\n"+r.requestHandler(request));
    }


    private static void testSelectFieldFromOrder() throws JsonProcessingException {
        String request = "{ \"type\": \"GET\" , \"table\": \"ORDER\", \"scope\":\"select\" , \"field\": \"OrderID\" , \"field_value\" : \"27051\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(request);
        ObjectNode o = (ObjectNode) jsonNode;
        o.put("table", "TOOL"); // dynamically change value of a jsonNode
        System.out.println(jsonNode);
    }


    @Test
    public static void userLoginTest() throws JsonProcessingException {
        Request r = new Request();
        String request = "{\"type\" : \"POST\", \"table\" : \"USER\", \"scope\": \"login\", \"username\":\"user01\", \"password\":\"hello123\"}"; //{"type" : "POST", "table" : "USER", "scope": "login", "username":"user01", "password":"hello123"}
        r.requestHandler(request);
    }
    @Test
    public static void userLoginTest2 () throws JsonProcessingException {
        Request r = new Request();
        String request = "{\"type\" : \"POST\", \"table\" : \"USER\", \"scope\": \"login\", \"username\":\"user01\", \"password\":\"hello143\"}"; //{"type" : "POST", "table" : "USER", "scope": "login", "username":"user01", "password":"hello143"}
        r.requestHandler(request);
    }

    public static void main(String[] args) throws JsonProcessingException {
//        testSelectFieldFromOrder();
//        userLoginTest();
//        userLoginTest2();
        Request r = new Request();
//        String request = "{\"type\" : \"POST\", \"table\" : \"TOOL\", \"ToolID\": \"1000\", \"Name\":\"Knock Bitzzz\", \"Type\":\"Electric\", \"Quantity\":\"120\", \"Price\":\"15\", \"SupplierID\":\"8004\"}"; //{"type" : "POST", "table" : "TOOL", "ToolID": "1000", "Name":"Knock Bitzzz", "Type":"Electric", "Quantity":"120", "Price":"15", "SupplierID":"8004"}
//        String request = "{\"type\" : \"POST\", \"table\" : \"CLIENT\", \"ClientID\": \"11\", \"LName\":\"sTANNN\", \"FName\":\"lEEEE\", \"Type\":\"Residential\", \"PhoneNum\":\"4039996666\", \"Address\":\"7899  Washington Street\", \"PostalCode\":\"0X0 OYO\"}"; //{"type" : "POST", "table" : "CLIENT", "ClientID": "11", "LName":"sTANNN", "FName":"lEEEE", "Type":"Residential", "PhoneNum":"4039996666", "Address":"7899  Washington Street", "PostalCode":"0X0 OYO"}
//        String request = "{\"type\" : \"PUT\", \"table\" : \"TOOL\", \"ToolID\": \"1097\", \"Name\":\"fake Knock Bitzzz\", \"Type\":\"Electric\", \"Quantity\":\"199\", \"Price\":\"15\", \"SupplierID\":\"8004\"}"; // {"type" : "PUT", "table" : "TOOL", "ToolID": "1097", "Name":"fake Knock Bitzzz", "Type":"Electric", "Quantity":"199", "Price":"15", "SupplierID":"8004"}
//        String request = "{\"type\" : \"DELETE\", \"table\": \"TOOL\" ,\"field\" : \"ToolID\", \"field_value\": \"1097\"}"; // {"type" : "DELETE", "table": "TOOL" ,"field" : "ToolID", "field_value": "1097"}
//        String request = "{\"type\" : \"DELETE\", \"table\": \"CLIENT\" ,\"field\" : \"ClientID\", \"field_value\": \"22\"}"; // {"type" : "DELETE", "table": "CLIENT" ,"field" : "ClientID", "field_value": "22"}
        String request = "{\"type\" : \"DELETE\", \"table\": \"SUPPLIER\" ,\"field\" : \"SupplierID\", \"field_value\": \"8099\"}"; // {"type" : "DELETE", "table": "SUPPLIER" ,"field" : "SupplierID", "field_value": "8099"}
        r.requestHandler(request);
    }


}
