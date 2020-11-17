package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventoryManager implements Runnable{
	private PreparedStatement preparedStmt;
    private Statement stmt;
    private Connection conn;
    private ResultSet rs;
    private PrintWriter socketOut;
	private BufferedReader socketIn;

	public InventoryManager(BufferedReader socketIn, PrintWriter socketOut, Connection conn) {
		
	this.socketIn=socketIn;
	this.socketOut=socketOut;
	this.conn=conn;
	}
	public void communicate() throws InterruptedException {
		String line = "";
		String response = "";
		boolean running = true;
		while (running) {
			try {
				System.err.println("here");
				menu();
				response=socketIn.readLine();
				System.err.println(response);
				//if statments for all USEr Actions in GUI
				if (Integer.parseInt(response)==1) {
					
					listAllTools();
					
				}
			}catch (Exception e) {
				System.out.println("Error reading from sockets");
			}
	}
		}
	private void menu() {

		String menue="Menu\n1-> List all tools"+"\n2-> Search tool by Name\n"+"3-> Search by ID\n"+"4-> Check item quatity\n"+"5-> Decrease an item by ID\n"+"6-> Quit";
		socketOut.println(menue);
	}
	private void listAllTools() {
		StringBuffer sb =new StringBuffer();
		  sb.append("Reading all tools from the table:\nTools:");
	        try {
	            String table = "items";
	            query("use tool_shop;");
	            String query = "select * from " +
	                    table;
	            PreparedStatement pStat = conn.prepareStatement(query);
	            rs = pStat.executeQuery();
	            while (rs.next()) {
	            	sb.append(rs.getString("id")+"\t");
	            	sb.append(rs.getString("description_name")+"\t");
	            	sb.append(rs.getString("quantity_in_stock")+"\t");
	            	sb.append(rs.getString("price")+"\t");
	            	sb.append(rs.getString("supplier_id")+"\n");
	            }
	            socketOut.println(sb);
	            pStat.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       
	}
	@Override
	public void run() {
		try {
			communicate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  public void query(String sql){
	        try (Statement stmt = conn.createStatement()) {
//	            System.out.println("Querying: \n" +
//	                    "----------"+sql+"\n----------");
	            stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
