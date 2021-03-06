package server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * The type Request.
 */
public class Request {
    /**
     * Request handler string.
     *
     * @param request the request
     * @return the string
     * @throws JsonProcessingException the json processing exception
     */
    public static String requestHandler(String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);
        String type = jsonNodeRoot.get("type").asText();
        Response response = new Response();
        String r = "";
        switch (type){
            case "GET":
                r = response.getHandler(request);
                break;
            case "POST":
                 response.postHandler(request);
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


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws JsonProcessingException the json processing exception
     */
    public static void main(String[] args) throws JsonProcessingException {

    }

}
