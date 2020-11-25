package preproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

// Pre-Project Exercise 

// This program allows you to create and manage a store inventory database.
// It creates a database and datatable, then populates that table with tools from
// items.txt.
public class InventoryManager {

	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "InventoryDB", tableName = "ToolTable", dataFile = "items.txt";

	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/tool_shop",
			login          = "testadmin",
			password       = "passw0rd";

	private PreparedStatement preparedStmt;
	private ResultSet rs;
	private BufferedReader reader;

	public InventoryManager(){
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.jdbc.Driver");
			// If this fails make sure your connectionInfo and login/password are correct
			this.connectDB("localhost:3306","mysql","testadmin", "passw0rd");

		} catch(Exception e) { e.printStackTrace(); }
	}

	// Use the jdbc connection to create a new database in MySQL.
	// (e.g. if you are connected to "jdbc:mysql://localhost:3306", the database will be created at "jdbc:mysql://localhost:3306/InventoryDB")
	public void createDB(){
		try {
			query("drop schema if exists tool_shop;");
			query("create schema tool_shop;");
			query("drop table if exists  items;"); // items has to be dropped first due to referential integrity
			query("drop table if exists  suppliers;");
			query("use tool_shop;");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Connect db.
	 *
	 * @param host     the host
	 * @param dbname   the dbname
	 * @param username the username
	 * @param password the password
	 */
	public void connectDB(String host, String dbname, String username, String password) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String url = "jdbc:mysql://"+host+"/"+dbname;
		try (Connection conn = DriverManager.getConnection(url,username,password)) {
			setJdbc_connection(DriverManager.getConnection(url,username,password));
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println(ts+"\nConnected to: "+url);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Create a data table inside of the database to hold tools
	public void createTables() {
		try {
			// flushing schema
			query("create table suppliers" +
					"(" +
					"id int auto_increment," +
					"company_name text null," +
					"address text null," +
					"sales_contact text null," +
					"constraint suppliers_pk " +
					"primary key (id)" +
					");");
			System.out.println("Created Table suppliers");
			query("create table items" +
					"(" +
					"id int auto_increment," +
					"description_name text null," +
					"quantity_in_stock int null," +
					"price float null," +
					"supplier_id int null," +
					"constraint items_pk " +
					"primary key (id)," +
					"constraint suppliers_suppliers_id_fk " +
					"foreign key (supplier_id) references suppliers (id) " +
					"on update cascade on delete set null" +
					");");
			System.out.println("Created Table ToolTable");

		} catch (Exception e) {
			System.err.println("Cant drop/create tables");
			return;
		}
	}

	// Removes the data table from the database (and all the data held within it!)
	public void removeTables(){
		System.out.println("Trying to remove the table");
		query("drop table if exists  items;"); // items has to be dropped first due to referential integrity
		System.out.println("Removed Table items");
		query("drop table if exists  suppliers;");
		System.out.println("Removed Table suppliers");
	}

	// Fills the data table with all the tools from the text file 'items.txt' if found
	public void fillToolsTable(String fileName) throws IOException {
		System.out.print("Filling the table with tools");
		reader = new BufferedReader(new FileReader(fileName));
		String line ="";
		try {
			line = reader.readLine();
			while (line != null) {
				String temp[];
				line = reader.readLine();
				temp = line.split("[;]");
				int id = Integer.parseInt(temp[0]);
				String description = temp[1];
				int quantity = Integer.parseInt(temp[2]);
				float price = Float.parseFloat(temp[3]);
				int supplierId = Integer.parseInt(temp[4]);
				Tool tool=new Tool(id, description, quantity,price,supplierId);

				addItem(tool);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		System.out.println("\t--Done");
	}

	// Add a tool to the database table
	private void addItem(Tool temp) {
		int id = temp.getItemID();
		String description = temp.getItemName();
		int quantity = temp.getQuantity();
		float price = (float) temp.getPrice();
		int supplierId = temp.getSupplierId();
		String query ="INSERT INTO items(id,description_name,quantity_in_stock,price,supplier_id) VALUES (?,?,?,?,?)";
		try {
			preparedStmt = jdbc_connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, description);
			preparedStmt.setInt(3, quantity);
			preparedStmt.setFloat(4, price);
			preparedStmt.setInt(5, supplierId);
//                    System.out.println(preparedStmt);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void fillSupplierTable(String fileName) {
		System.out.print("Filling the table with suppliers");
		try {

			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			line = reader.readLine();//skipping header
			while (line != null) {
				String temp[];

				temp = line.split("[;]");
				int id = Integer.parseInt(temp[0]);
				String company_name = temp[1];
				String adress = temp[2];
				String contact = temp[3];

				String query = "INSERT INTO suppliers(id,company_name,address,sales_contact) " + "VALUES (?,?,?,?)";

				try {
					preparedStmt = jdbc_connection.prepareStatement(query);
					preparedStmt.setInt(1, id);
					preparedStmt.setString(2, company_name);
					preparedStmt.setString(3, adress);
					preparedStmt.setString(4, contact);
					preparedStmt.executeUpdate();
//                    System.out.println(preparedStmt);

				} catch (SQLException e) {
					System.out.println(e);
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		System.out.println("\t--Done");
	}

	// This method should search the database table for a tool matching the toolID parameter and return that tool.
	public void searchTools(int toolID){
		String [] columns =  {"id", "description_name", "quantity_in_stock", "price", "supplier_id"};
		String searchText = String.valueOf(toolID);
		try {
			query("use tool_shop;");
			String query = "select * from " +
					"items" +
					" where " +
					"id" +
					" like ?; ";
			PreparedStatement pStat = jdbc_connection.prepareStatement(query);
			pStat.setString(1, searchText);
//            System.out.println(pStat);
			rs = pStat.executeQuery();
			if (!rs.next()){
				System.out.println("Search Failed to find a tool matching "+ "id" + ": "+searchText);
				return;
			} else {
				System.out.print("Search Result:\t");
				for (int i = 0; i < columns.length; i++)
					System.out.print (rs.getString(columns[i])+ "\t");
			}
			while (rs.next()) {
				for (int i = 0; i < columns.length; i++)
					System.out.print (rs.getString(columns[i])+ "\t");
			}
			System.out.println("\n");
			pStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Prints all the items in the database to console
	public void printTableItems(){
		System.out.println("Reading all tools from the table:\nTools:");
		try {
			String table = "items";
			query("use tool_shop;");
			String query = "select * from " +
					table;
			PreparedStatement pStat = jdbc_connection.prepareStatement(query);
			rs = pStat.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("description_name")+"\t");
				System.out.print(rs.getString("quantity_in_stock")+"\t");
				System.out.print(rs.getString("price")+"\t");
				System.out.print(rs.getString("supplier_id")+"\n");
			}
			pStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n");
	}

	public void printTableSuppliers(){
		System.out.println("Reading all suppliers from the table:\nSuppliers:");
		try {
			String table = "suppliers";
			query("use tool_shop;");
			String query = "select * from " +
					table;
			PreparedStatement pStat = jdbc_connection.prepareStatement(query);
			rs = pStat.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("company_name")+"\t");
				System.out.print(rs.getString("address")+"\t");
				System.out.print(rs.getString("sales_contact")+"\n");
			}
			pStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n");
	}

	public void setJdbc_connection(Connection jdbc_connection) {
		this.jdbc_connection = jdbc_connection;
	}

	public void query(String sql){
		try (Statement stmt = jdbc_connection.createStatement()) {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			statement.close();
			rs.close();
			jdbc_connection.close();
		} catch (SQLException e) {}
		catch (NullPointerException e){}
		return;
	}

	public static void main(String args[]) throws IOException {
		InventoryManager jdbc = new InventoryManager();
		jdbc.createDB();
		jdbc.createTables();
		jdbc.fillSupplierTable("suppliers.txt");
		jdbc.fillToolsTable("items.txt");
		jdbc.printTableItems();
		jdbc.printTableSuppliers();
		System.out.println("Searching table for tool 1002: should return 'Grommets'");
		jdbc.searchTools(1002);
		System.out.println("Searching table for tool 9000: should fail to find a tool");
		jdbc.searchTools(9000);
		jdbc.removeTables();
		jdbc.close();
		System.out.println("The program is finished running");
	}
}
