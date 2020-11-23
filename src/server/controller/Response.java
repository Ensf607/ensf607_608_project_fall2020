package server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {
    static String getHandler(String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);
        String tableName = jsonNodeRoot.get("table").asText();
        JDBC jdbc = getJdbc();
        switch (jsonNodeRoot.get("scope").asText()){
            case "all":
                return jdbc.getTable(tableName);
            case "select":
                String field = jsonNodeRoot.get("field").asText();
                String fieldValue = jsonNodeRoot.get("field_value").asText();
//                System.out.println(field + " " + fieldValue);
                return jdbc.getSearchResult(tableName, field, fieldValue);
            default:
                return "";
        }
    }

    public static void putHandler(String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);
        JDBC jdbc = getJdbc();
        switch (jsonNodeRoot.get("table").asText())
        {
            case "CLIENT":
                jdbc.insertIntoCLIENT(jsonNodeRoot.get("ClientID").asText(),
                        jsonNodeRoot.get("LName").asText(),
                        jsonNodeRoot.get("FName").asText(),
                        jsonNodeRoot.get("Type").asText(),
                        jsonNodeRoot.get("PhoneNum").asText(),
                        jsonNodeRoot.get("Address").asText(),
                        jsonNodeRoot.get("PostalCode").asText()
                );
                break;
            case "ORDER":
                jdbc.insertIntoORDER_(jsonNodeRoot.get("OrderID").asText(),
                        jsonNodeRoot.get("Date").asText());
                break;
            case "ORDERLINE":
                jdbc.insertIntoORDERLINE(jsonNodeRoot.get("OrderID").asText(),
                        jsonNodeRoot.get("ToolID").asText(),
                        jsonNodeRoot.get("SupplierID").asText(),
                        jsonNodeRoot.get("Quantity").asText()
                );
                break;
            case "PURCHASE":
                jdbc.insertIntoPURCHASE(jsonNodeRoot.get("ClientID").asText(),
                        jsonNodeRoot.get("ToolID").asText(),
                        jsonNodeRoot.get("Date").asText()
                        );
                break;
            case "SUPPLIER":
                jdbc.insertIntoSUPPLIER(jsonNodeRoot.get("SupplierID").asText(),
                        jsonNodeRoot.get("Name").asText(),
                        jsonNodeRoot.get("Type").asText(),
                        jsonNodeRoot.get("Address").asText(),
                        jsonNodeRoot.get("CName").asText(),
                        jsonNodeRoot.get("Phone").asText()
                );
                break;
            case "TOOL":
                jdbc.insertIntoTOOL(jsonNodeRoot.get("ToolID").asText(),
                        jsonNodeRoot.get("Name").asText(),
                        jsonNodeRoot.get("Type").asText(), // please note this type is special "Type" Cap
                        jsonNodeRoot.get("Quantity").asText(),
                        jsonNodeRoot.get("Price").asText(),
                        jsonNodeRoot.get("SupplierID").asText()
                );
                break;
            case "ELECTRICAL":
                jdbc.insertIntoELECTRICAL(
                        jsonNodeRoot.get("ToolID").asText(),
                        jsonNodeRoot.get("PowerType").asText()
                );
                break;
            case "INTERNATIONAL":
                jdbc.insertIntoINTERNATIONAL(
                        jsonNodeRoot.get("SupplierID").asText(),
                        jsonNodeRoot.get("ImportTax").asText()
                );

        }


        return;
    }

    /**
     * Right now by default it's updating everything if gui need to enter something.
     * @param request
     * @throws JsonProcessingException
     */
    static void postHandler(String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);
        JDBC jdbc = getJdbc();
        String sql = "";
        switch (jsonNodeRoot.get("table").asText())
        {
            case "TOOL":
                sql = "UPDATE TOOL "
                        +"SET ToolID == "+jsonNodeRoot.get("ToolID")+", "
                        +"SET Name == "+jsonNodeRoot.get("Name")+", "
                        +"SET Type == "+jsonNodeRoot.get("Type")+", "
                        +"SET Quantity == "+jsonNodeRoot.get("Quantity")+", "
                        +"SET Price == "+jsonNodeRoot.get("Price")+", "
                        +"SET SupplierID == "+jsonNodeRoot.get("SupplierID")
                        + " WHERE " + jsonNodeRoot.get("field").asText()+" == "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                break;
            case "CLIENT":
                sql = "UPDATE CLIENT "
                        +"SET ClientID == "+jsonNodeRoot.get("ClientID")+", "
                        +"SET LName == "+jsonNodeRoot.get("LName")+", "
                        +"SET FName == "+jsonNodeRoot.get("FName")+", "
                        +"SET Type == "+jsonNodeRoot.get("Type")+", "
                        +"SET PhoneNum == "+jsonNodeRoot.get("PhoneNum")+", "
                        +"SET Address == "+jsonNodeRoot.get("Address")+", "
                        +"SET PostalCode == "+jsonNodeRoot.get("PostalCode")
                        + " WHERE " + jsonNodeRoot.get("field").asText()+" == "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                break;
            default:
                break;
        }
    }

    static void deleteHandler(String request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);
        JDBC jdbc = getJdbc();
        String sql = "";
        switch (jsonNodeRoot.get("table").asText())
        {
            case "TOOL":
                sql = "DELETE FROM TOOL WHERE "+
                        jsonNodeRoot.get("field").asText()+" == "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                break;
            case "CLIENT":
                sql= "DELETE FROM CLIENT WHERE "+
                        jsonNodeRoot.get("field").asText()+" == "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                break;

            case "ORDERLINE":
            case "ORDER":
                sql= "DELETE FROM ORDER_ WHERE "+
                        jsonNodeRoot.get("field").asText()+" == "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                sql= "DELETE FROM ORDERLINE WHERE "+
                        jsonNodeRoot.get("field").asText()+" == "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                break;
            case "PURCHASE":
            case "SUPPLIER":
            case "ELECTRICAL":
            case "INTERNATIONAL":
                break;
        }
        return;
    }

    private static JDBC getJdbc() {
        JDBC jdbc = new JDBC();
//        jdbc.connectDB("18.236.191.241:3306", "ToolShop", "testadmin", "passw0rd");
        jdbc.query("use ToolShop;");
        return jdbc;
    }
}
