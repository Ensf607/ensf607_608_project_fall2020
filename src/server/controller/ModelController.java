package server.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Shop;

public class ModelController implements Runnable{
    private ResultSet rs;
	ServerController server;
	Shop shop;
	JDBC jdbc;

	public ModelController(ServerController server) {
		this.server=server;
		jdbc=new JDBC();
	}
	public void communicate() throws InterruptedException {
		while(true) {
			server.recieve();
		//JASON=server.recieve();
		
		//decode jason object
		//based on jason object either query jdbc and will recieve a ResultSet or simply get a jason from model 
		//EX if Jason requires a list of tools then no need to query DataBase, simply get itemsList Jason from Model
		//if JASON requires to update DB ,update both model and DB
		
		//EX Cutomer bought item 101 then update DB Customer table and Purchase Table, items table ,etc 
		//check if need to create an orderin model
		//if new order is created then update db orderline for example
		//sql toolTable
		// Inventory add(item)
		
		
		//jdbc.updateCustomer(customer info) 
		//jdbc.updateItems(item,Quantity
		// then update local model
		
		//check if we need new orderline
		//are we updating ItemTable when we generate Order or wait for supplier to ship the items
			
			
		
		
		
		//send JASON for displaying tables ex: toollist, supplierlist, orderlist,
		//server.send(JASON file);
		}
		}
	
	
	
	@Override
	public void run() {
		
		//query to get customer list ,item list, supplierlist, orderList, purchaseList
		//create shop (ResultSet toolist, supl
		
		try {
			communicate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
