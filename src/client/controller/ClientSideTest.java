package client.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

class ClientSideTest {

	

	@Test
	void test() throws JsonProcessingException, IOException {
		Client aClient = new Client("localhost", 9090);
		ModelController mc =new ModelController(aClient);
		//the model controller will use client send method 
		
		
		//NOTE: THIS json SHOULD BE GENERATED WHEN BTN IS PUSHED, then use modelController request()method to send msg to server
		//Your jason must have some kind of a message to server so it knows what to do 
		////example of json message  {Type: Get,From:tool,Method:all)
		 ObjectNode node=new ObjectMapper().createObjectNode();
		 node.put("Type", "Get");
		 node.put("From", "Tool");
		 String msg =new ObjectMapper().writeValueAsString(node);
		String response=mc.request(msg);
		System.out .println("RESPONSE FROM SERVER");
		System.out.println(response);
	}

}
