package _test;

import com.fasterxml.jackson.core.JsonProcessingException;
import server.controller.Request;

import java.io.IOException;

public class RequestResponseTest {
    public static void main(String[] args) throws IOException {
        String request =
                "{ \"type\" : \"GET\", \"table\" : \"ORDER\" , \"scope\":\"all\"}";

        Request r = new Request();
        r.requestHandler(request);
    }
}
