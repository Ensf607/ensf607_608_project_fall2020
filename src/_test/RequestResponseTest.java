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


    public static void main(String[] args) throws JsonProcessingException {
        String request = "{ \"type\": \"GET\" , \"table\": \"ORDER\", \"scope\":\"select\" , \"field\": \"OrderID\" , \"field_value\" : \"27051\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(request);
        ObjectNode o = (ObjectNode) jsonNode;
        o.put("table", "TOOL"); // dynamically change value of a jsonNode
        System.out.println(jsonNode);
    }



}
