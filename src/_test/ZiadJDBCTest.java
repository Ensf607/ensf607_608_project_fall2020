package _test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import server.controller.JDBC;

class ZiadJDBCTest {

	@Test
	void test() throws SQLException, IOException {
		
		JDBC t= new JDBC();
		try {
			t.checkInventory();
			String g=t.getItemsList(); 
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode[] n=objectMapper.readValue(g, ObjectNode[].class);
//			int f=(n[0].get("OrderID").asInt());
			System.err.println(g);
			//Map<String, Object> jsonMap = objectMapper.readValue(g,new TypeReference<Map<String,Object>>(){});
//			ArrayList<Object>jsonMap=objectMapper.readValue(g,new TypeReference<ArrayList<Object>>(){});
//			
//			JsonNode jsonNode = objectMapper.convertValue(jsonMap.get(0), JsonNode.class);
//			System.out.println(jsonMap.get(0));
//			
//			System.out.println(jsonNode.get("Date"));
//			t.purchase(1000, 20, 10);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//t.purchase(1000, 2, 1);
		fail("Not yet implemented");
		
	}

}
