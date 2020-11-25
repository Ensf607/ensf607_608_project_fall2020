package server.controller;

import client.controller.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.*;

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
        ModelController mc = new ModelController();
        switch (jsonNodeRoot.get("table").asText())
        {
            case "CLIENT":
                mc.setClient(new Customer(
                        jsonNodeRoot.get("ClientID").asInt(),
                        jsonNodeRoot.get("LName").asText(),
                        jsonNodeRoot.get("FName").asText(),
                        jsonNodeRoot.get("Type").asText(),
                        jsonNodeRoot.get("PhoneNum").asText(),
                        jsonNodeRoot.get("Address").asText(),
                        jsonNodeRoot.get("PostalCode").asText()
                ));
//                System.out.println(mc.getClient().toString());
                jdbc.insertIntoCLIENT(String.valueOf(mc.getClient().getClientID()),
                        mc.getClient().getFirstName(),
                        mc.getClient().getLastName(),
                        mc.getClient().getClientType(),
                        mc.getClient().getPhoneNumber(),
                        mc.getClient().getAddress(),
                        mc.getClient().getPostolCode()
                );
                break;
            case "ORDER":
                mc.setOrder(new Order(jsonNodeRoot.get("OrderID").asInt(),
                        jsonNodeRoot.get("Date").asText()));

                jdbc.insertIntoORDER_(String.valueOf(mc.getOrder().getOrderID()),
                        mc.getOrder().getDate());
                break;
            case "ORDERLINE":

                mc.setOrderLine(new OrderLine(
                        jsonNodeRoot.get("OrderID").asInt(),
                        jsonNodeRoot.get("ToolID").asInt(),
                        jsonNodeRoot.get("SupplierID").asInt(),
                        jsonNodeRoot.get("Quantity").asInt()
                ));
                jdbc.insertIntoORDERLINE(String.valueOf(mc.getOrderLine().getOrderID()),
                        String.valueOf(mc.getOrderLine().getToolID()),
                        String.valueOf(mc.getOrderLine().getSupplierID()),
                        String.valueOf(mc.getOrderLine().getAmount())
                );
                break;
            case "PURCHASE":
                mc.setPurchase(new Purchase(
                        jsonNodeRoot.get("ClientID").asInt(),
                        jsonNodeRoot.get("ToolID").asInt(),
                        jsonNodeRoot.get("Date").asText()
                ));
                jdbc.insertIntoPURCHASE(String.valueOf(mc.getPurchase().getClientID()),
                        String.valueOf(mc.getPurchase().getToolID()),
                        mc.getPurchase().getDate()
                        );
                break;
            case "SUPPLIER":
                mc.setSupplier(new Supplier(
                        jsonNodeRoot.get("SupplierID").asInt(),
                        jsonNodeRoot.get("Name").asText(),
                        jsonNodeRoot.get("Type").asText(),
                        jsonNodeRoot.get("Address").asText(),
                        jsonNodeRoot.get("CName").asText(),
                        jsonNodeRoot.get("Phone").asText()
                ));

                jdbc.insertIntoSUPPLIER(String.valueOf(mc.getSupplier().getId()),
                        mc.getSupplier().getSupplierName(),
                        mc.getSupplier().getType(),
                        mc.getSupplier().getSupplierAddress(),
                        mc.getSupplier().getSalesPerson(),
                        mc.getSupplier().getPhoneNumber()
                );
                break;
            case "TOOL":
                mc.setItem(new Item(
                        jsonNodeRoot.get("ToolID").asInt(),
                        jsonNodeRoot.get("Name").asText(),
                        jsonNodeRoot.get("Type").asText(), // please note this type is special "Type" Cap
                        jsonNodeRoot.get("Quantity").asInt(),
                        jsonNodeRoot.get("Price").asDouble(),
                        jsonNodeRoot.get("SupplierID").asInt()
                ));

                jdbc.insertIntoTOOL(String.valueOf(mc.getItem().getItemID()),
                        String.valueOf(mc.getItem().getItemName()),
                        String.valueOf(mc.getItem().getType()), // please note this type is special "Type" Cap
                        String.valueOf(mc.getItem().getQuantity()),
                        String.valueOf(mc.getItem().getPrice()),
                        String.valueOf(mc.getItem().getSupplierId())
                );
                break;
            case "ELECTRICAL":
                mc.setElectrical(new Electrical());
                mc.getElectrical().setToolID(jsonNodeRoot.get("ToolID").asInt());
                mc.getElectrical().setPowerType(jsonNodeRoot.get("PowerType").asText());

                jdbc.insertIntoELECTRICAL(
                        String.valueOf(mc.getElectrical().getToolID()),
                        mc.getElectrical().getPowerType()
                );
                break;
            case "INTERNATIONAL":
                mc.setInternational(new International());
                mc.getInternational().setSupplierID(jsonNodeRoot.get("SupplierID").asInt());
                mc.getInternational().setImportTax(jsonNodeRoot.get("ImportTax").asDouble());
                jdbc.insertIntoINTERNATIONAL(
                        String.valueOf(mc.getInternational().getSupplierID()),
                        String.valueOf(mc.getInternational().getImportTax())
                );

        }


        return;
    }

    /**
     * Right now by default it's updating everything if gui need to enter something.
     * @param request
     * @throws JsonProcessingException
     * @return
     */
    static String postHandler(String request) throws JsonProcessingException {
        String message = "{\"error\" : \"0\" }"; // {"error" : "0" }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeRoot = objectMapper.readTree(request);
        JDBC jdbc = getJdbc();
        String sql = "";
        switch (jsonNodeRoot.get("table").asText())
        {
            case "TOOL":
                sql = "UPDATE TOOL "
                        +"SET ToolID = "+jsonNodeRoot.get("ToolID").asText()+", "
                        +"SET Name = '"+jsonNodeRoot.get("Name").asText()+"', "
                        +"Type = '"+jsonNodeRoot.get("Type").asText()+"', "
                        +"Quantity = "+jsonNodeRoot.get("Quantity").asText()+", "
                        +"Price = "+jsonNodeRoot.get("Price").asText()+", "
                        +"SupplierID = "+jsonNodeRoot.get("SupplierID").asText()
                        + " WHERE " + "ToolID"+" = "+jsonNodeRoot.get("ToolID").asText()+";"; // this will be ToolID, no wrapping needed
                jdbc.query(sql);
                jdbc.checkInventory();
                break;
            case "CLIENT":
                sql = "UPDATE CLIENT "
                        +"SET LName = '"+jsonNodeRoot.get("LName").asText()+"', "
                        +"FName = '"+jsonNodeRoot.get("FName").asText()+"', "
                        +"Type = '"+jsonNodeRoot.get("Type").asText()+"', "
                        +"PhoneNum = '"+jsonNodeRoot.get("PhoneNum").asText()+"', "
                        +"Address = '"+jsonNodeRoot.get("Address").asText()+"', "
                        +"PostalCode = '"+jsonNodeRoot.get("PostalCode").asText()+"'"
                        + " WHERE " + "ClientID" +" = "+jsonNodeRoot.get("ClientID").asText()+";";
                System.out.println(sql);
                jdbc.query(sql);
                jdbc.checkInventory();
                break;
            case "USER":
                message= jdbc.validateLogin(jsonNodeRoot.get("username").asText(), jsonNodeRoot.get("password").asText());
                break;
            default:
                break;

        }
        return message;

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
                        jsonNodeRoot.get("field").asText()+" = "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                break;
            case "CLIENT":
                sql= "DELETE FROM CLIENT WHERE "+
                        jsonNodeRoot.get("field").asText()+" = "+jsonNodeRoot.get("field_value");
                System.out.println(sql);
                jdbc.query(sql);
                break;

            case "ORDERLINE":
            case "ORDER":
                sql= "DELETE FROM ORDER_ WHERE "+
                        jsonNodeRoot.get("field").asText()+" = "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                sql= "DELETE FROM ORDERLINE WHERE "+
                        jsonNodeRoot.get("field").asText()+" = "+jsonNodeRoot.get("field_value");
                jdbc.query(sql);
                break;
            case "PURCHASE":
            case "SUPPLIER":
                sql= "DELETE FROM SUPPLIER WHERE "+
                        jsonNodeRoot.get("field").asText()+" = "+jsonNodeRoot.get("field_value");
                System.out.println(sql);
                jdbc.query(sql);
                break;
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

    public static void main(String[] args) throws JsonProcessingException {
    }
}
