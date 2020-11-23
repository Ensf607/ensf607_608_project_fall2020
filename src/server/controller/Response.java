package server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {
    static String getHandler(String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);

        String type = jsonNodeRoot.get("type").asText(); // DEBUG
//        System.out.println(type); // DEBUG
//        System.out.println(jsonNodeRoot.get("table")); // DEBUG
//        System.out.println(jsonNodeRoot.get("scope")); // DEBUG
        String tableName = jsonNodeRoot.get("table").asText();

        JDBC jdbc = getJdbc();
//        System.out.println(jdbc.getTable(tableName));


        switch (jsonNodeRoot.get("scope").asText()){
            case "all":
                return jdbc.getTable(tableName);
            case "select":
                String field = jsonNodeRoot.get("field").asText();
                String fieldValue = jsonNodeRoot.get("field_value").asText();
                return jdbc.getSearchResult(tableName, field, fieldValue);
            default:
                return "";
        }
    }

    private static JDBC getJdbc() {
        JDBC jdbc = new JDBC();
//        jdbc.connectDB("18.236.191.241:3306", "ToolShop", "testadmin", "passw0rd");
        jdbc.query("use ToolShop;");
        return jdbc;
    }
}
