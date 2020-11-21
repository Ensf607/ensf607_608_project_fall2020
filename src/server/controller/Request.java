package server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Request {
    public static void requestHandler(String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);
        String type = jsonNodeRoot.get("type").asText();

        switch (type){
            case "GET":
                Response response = new Response();
                System.out.println(response.getHandler(request));
                break;
            default:
                break;
        }
        ;
    }

}
