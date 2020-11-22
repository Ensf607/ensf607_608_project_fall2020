package _test;

import com.fasterxml.jackson.core.JsonProcessingException;
import server.controller.Request;

public class RequestResponseTest {
    public static void main(String[] args) throws JsonProcessingException {
        String request =
                "{ \"type\" : \"GET\", \"table\" : \"ORDER\" , \"scope\":\"all\"}";

        Request r = new Request();
        r.requestHandler(request);
    }
}
