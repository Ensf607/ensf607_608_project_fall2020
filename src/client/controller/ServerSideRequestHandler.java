package client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import server.controller.JDBC;

public class ServerSideRequestHandler {
private JDBC t;
//The server will use this class to decode your json
public ServerSideRequestHandler()
{
	 t=new JDBC();
}
	public String getResponse(String json) throws JsonMappingException, JsonProcessingException {
		
		 ObjectMapper objectMapper = new ObjectMapper();
	    ObjectNode node = objectMapper.readValue(json, ObjectNode.class);
	    System.out.println(node);
	    ObjectNode response=objectMapper.createObjectNode();
	    
	    //ADD AS MANY AS YOU NEED 
	   if(node.get("type").asText().equals("GET")) {
		  switch (node.get("table").asText()){
		  case "TOOL":
		  {		if(node.get("scope").asText().equals("all")) {
			     return t.getItemsList();
		  }
		  else if(node.get("scope").asText().equals("select")) {
			  System.err.println(node.hasNonNull("ToolID"));
			  if (node.hasNonNull("ToolID")) {
				 String g= t.searchForToolID(node.get("ToolID").asInt());
				 return g;}
				 else if(node.hasNonNull("ToolName")) {
					 String g= t.searchForToolName(node.get("ToolName").asText());
					 return g;
				  
			  }
		  }
		  }}
	   }
	return null;
	}
}
