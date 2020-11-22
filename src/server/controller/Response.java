package server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Response {
    static String getHandler(String request) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);

        String type = jsonNodeRoot.get("type").asText(); // DEBUG
        System.out.println(type); // DEBUG
        System.out.println(jsonNodeRoot.get("table")); // DEBUG
        System.out.println(jsonNodeRoot.get("scope")); // DEBUG

        String tableName = jsonNodeRoot.get("table").asText();

        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getTable(tableName));


        switch (jsonNodeRoot.get("scope").asText()){
            case "all":
                return jdbc.getTable(tableName);
            case "select":
                System.err.println("select feature not yet implemented");
                break;
        }
        return "type";
    }

    private static JDBC getJdbc() {
        JDBC jdbc = new JDBC();
//        jdbc.connectDB("18.236.191.241:3306", "ToolShop", "testadmin", "passw0rd");
        jdbc.query("use ToolShop;");
        return jdbc;
    }
}
