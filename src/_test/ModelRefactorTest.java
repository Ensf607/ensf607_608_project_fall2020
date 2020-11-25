package _test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import server.controller.Request;

public class ModelRefactorTest {
    public static void main(String[] args) throws JsonProcessingException {
        Request r = new Request();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode request = mapper.createObjectNode();
        request.put("type", "PUT");
        request.put("table", "SUPPLIER");
        request.put("SupplierID", "8091");
        request.put("Name", "refactor test name");
        request.put("Type", "Local");
        request.put("Address", "3410  Coburn Hollow Road");
        request.put("CName", "refac name");
        request.put("Phone", "4030012985");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
        r.requestHandler(jsonString);
    }

    private static void putClientTest() throws JsonProcessingException {
        Request r = new Request();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode request = mapper.createObjectNode();
        request.put("type", "PUT");
        request.put("table", "CLIENT");
        request.put("ClientID", "21");
        request.put("LName", "Walter");
        request.put("FName", "White");
        request.put("Type", "Residential");
        request.put("PhoneNum", "4030012985");
        request.put("Address", "3410  Coburn Hollow Road");
        request.put("PostalCode", "0X0 OYO");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
        r.requestHandler(jsonString);
    }
}
