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
        String r = "";
        switch (type){
            case "GET":
                r = response.getHandler(request);
                System.out.println(r); // disable this for production
                break;
            case "POST":
                response.postHandler(request);
                break;
            case "PUT":
                response.putHandler(request);
                break;
            case "DELETE":
                response.deleteHandler(request);
            default:
                break;
        }
        return r;
    }

}
