package server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
                r = response.postHandler(request);
                System.out.println(r);
                break;
            case "PUT":
                response.putHandler(request); // TODO: complete full api by returning error message
                break;
            case "DELETE":
                response.deleteHandler(request); //TODO: complete full api by returning error message
            default:
                break;
        }
        return r;
    }


    public static void main(String[] args) throws JsonProcessingException {

    }

}
