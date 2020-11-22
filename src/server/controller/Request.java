package server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Request {
    public static String requestHandler(String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);
        String type = jsonNodeRoot.get("type").asText();


        Response response = new Response();
        String r = response.getHandler(request);
        switch (type){
            case "GET":
                System.out.println();
                break;
            default:
                break;
        }
        return r;
    }

}
