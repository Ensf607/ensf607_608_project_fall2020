package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * Not needed but makes Customer class less messy
 * 
 */
public class CustomerList {
	ArrayList<Customer> customerList=new ArrayList<Customer>();
	ResultSet customers;
	public CustomerList(ResultSet customers) {
		this.customers=customers;
		//traverse and update arraylist
		  try {
			while (customers.next()) {
			      System.out.print(customers.getString("id")+"\t");
			      System.out.print(customers.getString("company_name")+"\t");
			      System.out.print(customers.getString("address")+"\t");
			      System.out.print(customers.getString("sales_contact")+"\n");
			      //check type of customer based of type u create Residential or commercial Customer
			      //add customer to arraylist
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	public String toJSON(){
        String json = new String();
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(this);
            System.out.println("ResultingJSONstring = " + json);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
	
	}


