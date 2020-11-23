package _test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import server.controller.Request;

public class RequestResponseTest {
    public static void main(String[] args) throws JsonProcessingException {
//        testFullSelect();
        testSelectWhere();


    }

    private static void testSelectWhere() throws JsonProcessingException {
        /**
         * example:
         * { "type": "GET" , "table": "ORDER", "scope":"select" , "field": "OrderID" , "field_value" : "27051"}
         */
        String getSelectTable = "{ \"type\": \"GET\" , \"table\": \"ORDER\", \"scope\":\"select\" , \"field\": \"OrderID\" , \"field_value\" : \"27051\"}";
        testRequest(getSelectTable);
    }

    private static void testFullSelect() throws JsonProcessingException {
        /**
         * example:
         * { "type" : "GET", "table" : "ORDER" , "scope":"all"}
         */
        String getFullTable = "{ \"type\" : \"GET\", \"table\" : \"ORDER\" , \"scope\":\"all\"}";
        testRequest(getFullTable);
    }

    @Test
    public static void testRequest(String request) throws JsonProcessingException {
        Request r = new Request();
        System.out.println("response is :\n"+r.requestHandler(request));
    }



}
