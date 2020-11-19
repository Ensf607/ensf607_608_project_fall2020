package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public void updateClass(ResultSet rs) {
		
		
	}
	}


