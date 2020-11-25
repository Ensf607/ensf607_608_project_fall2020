package server.preproject;

import server.model.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

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

	public InventoryManager()
	{
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.jdbc.Driver");
			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}

	// Use the jdbc connection to create a new database in MySQL.
	// (e.g. if you are connected to "jdbc:mysql://localhost:3306", the database will be created at "jdbc:mysql://localhost:3306/InventoryDB")
	public void createDB()
	{
		try {
			statement = jdbc_connection.createStatement();
			statement.executeUpdate("CREATE DATABASE " + databaseName);
			System.out.println("Created Database " + databaseName);
		}
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
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

	public void createTable()
	{
		String sql = "CREATE TABLE " + tableName + "(" +
				"ID INT(4) NOT NULL, " +
				"TOOLNAME VARCHAR(20) NOT NULL, " +
				"QUANTITY INT(4) NOT NULL, " +
				"PRICE DOUBLE(5,2) NOT NULL, " +
				"SUPPLIERID INT(4) NOT NULL, " +
				"PRIMARY KEY ( id ))";
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created Table " + tableName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	// Removes the data table from the database (and all the data held within it!)

	public void removeTable()
	{
		String sql = "DROP TABLE " + tableName;
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Removed Table " + tableName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	// Fills the data table with all the tools from the text file 'items.txt' if found

	public void fillTable()
	{
		try{
			Scanner sc = new Scanner(new FileReader(dataFile));
			while(sc.hasNext())
			{
				String toolInfo[] = sc.nextLine().split(";");
				addItem( new Item( Integer.parseInt(toolInfo[0]),
						toolInfo[1],
						Integer.parseInt(toolInfo[2]),
						Double.parseDouble(toolInfo[3]),
						Integer.parseInt(toolInfo[4])) );
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File " + dataFile + " Not Found!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	// Add a tool to the database table

	public void addItem(Item tool)
	{
		String sql = "INSERT INTO " + tableName +
				" VALUES ( " + tool.getItemID() + ", '" +
				tool.getItemName() + "', " +
				tool.getQuantity() + ", " +
				tool.getPrice() + ", " +
				tool.getSupplierId() + ");";
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	// This method should search the database table for a tool matching the toolID parameter and return that tool.
	// It should return null if no tools matching that ID are found.

	public Item searchTool(int toolID)
	{
		String sql = "SELECT * FROM " + tableName + " WHERE ID=" + toolID;
		ResultSet tool;
		try {
			statement = jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);
			if(tool.next())
			{
				return new Item(tool.getInt("ID"),
						tool.getString("TOOLNAME"),
						tool.getInt("QUANTITY"),
						tool.getDouble("PRICE"),
						tool.getInt("SUPPLIERID"));
			}

		} catch (SQLException e) { e.printStackTrace(); }

		return null;
	}
	// Prints all the items in the database to console

	public void printTable()
	{
		try {
			String sql = "SELECT * FROM " + tableName;
			statement = jdbc_connection.createStatement();
			ResultSet tools = statement.executeQuery(sql);
			System.out.println("Tools:");
			while(tools.next())
			{
				System.out.println(tools.getInt("ID") + " " +
						tools.getString("TOOLNAME") + " " +
						tools.getInt("QUANTITY") + " " +
						tools.getDouble("PRICE") + " " +
						tools.getInt("SUPPLIERID"));
			}
			tools.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getJdbc_connection() {
		return jdbc_connection;
	}

	public void setJdbc_connection(Connection jdbc_connection) {
		this.jdbc_connection = jdbc_connection;
	}

	public void query(String sql){
		try (Statement stmt = jdbc_connection.createStatement()) {
//            System.out.println("Querying: \n" +
//                    "----------"+sql+"\n----------");
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

	public void createTables() {
		try {
			// flushing schema
			query("drop schema if exists tool_shop;");
			query("create schema tool_shop;");
			query("drop table if exists  items;"); // items has to be dropped first due to referential integrity
			query("drop table if exists  suppliers;");
			query("use tool_shop;");

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

	/**
	 * D2L provided code
	 * Insert user prepared statement.
	 */
	public void insertUserPreparedStatement() {
		try {
			String query = "INSERT INTO users (ID,username, password) values" +
					"(?,?,?)";
			PreparedStatement pStat = jdbc_connection.prepareStatement(query);
			pStat.setInt(1, 1004);
			pStat.setString(2, "newUser");
			pStat.setString(3, "newPass");
			int rowCount = pStat.executeUpdate();
			System.out.println("row Count = " + rowCount);
			pStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addItemList(String fileName) {
		System.out.print("Filling the table with tools");
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			line = reader.readLine();
			while (line != null) {
				String temp[];

				temp = line.split("[;]");
				int id = Integer.parseInt(temp[0]);
				String description = temp[1];
				int quantity = Integer.parseInt(temp[2]);
				float price = Float.parseFloat(temp[3]);
				int supplierId = Integer.parseInt(temp[4]);
				String query ="INSERT INTO items(id,description_name,quantity_in_stock,price,supplier_id) VALUES (?,?,?,?,?)";;


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

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		System.out.println("\t--Done");
	}

	public void addSupplierList(String fileName) {
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

	public void searchGeneralPurpose(String table, String column, String strWithWildcard, String[] columns){
		try {
			query("use tool_shop;");
			String query = "select * from " +
					table +
					" where " +
					column +
					" like ?; ";
			PreparedStatement pStat = jdbc_connection.prepareStatement(query);
			pStat.setString(1, strWithWildcard);
//            System.out.println(pStat);
			rs = pStat.executeQuery();
			if (!rs.next()){
				System.out.println("Search Failed to find a tool matching "+column + ": "+strWithWildcard);
				return;
			} else {
				System.out.print("Search Result:\t");
				displayReturnStatement(columns);
			}

			while (rs.next()) {
				displayReturnStatement(columns);
			}
			System.out.println("\n");
			pStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void displayReturnStatement(String[] columns) throws SQLException {
		for (int i = 0; i < columns.length; i++)
			System.out.print (rs.getString(columns[i])+ "\t");
	}

	public void selectFromItems(){
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

	public void selectFromSuppliers(){
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

	public void searchForToolID(int toolID){
		String [] columns =  {"id", "description_name", "quantity_in_stock", "price", "supplier_id"};
		searchGeneralPurpose("items","id", String.valueOf(toolID),columns);
	}

	public void removeTables(){
		System.out.println("Trying to remove the table");
		query("drop table if exists  items;"); // items has to be dropped first due to referential integrity
		System.out.println("Removed Table items");
		query("drop table if exists  suppliers;");
		System.out.println("Removed Table suppliers");
	}

	private static void mainUsingStatement() {
		InventoryManager inventory = new InventoryManager();

		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		inventory.createDB();

		inventory.createTable();

		System.out.println("\nFilling the table with tools");
		inventory.fillTable();

		System.out.println("Reading all tools from the table:");
		inventory.printTable();

		System.out.println("\nSearching table for tool 1002: should return 'Grommets'");
		int toolID = 1002;
		Item searchResult = inventory.searchTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());

		System.out.println("\nSearching table for tool 9000: should fail to find a tool");
		toolID = 9000;
		searchResult = inventory.searchTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());

		System.out.println("\nTrying to remove the table");
		inventory.removeTable();

		try {
			inventory.statement.close();
			inventory.jdbc_connection.close();
		}
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
	}

	private static void mainUsingPreparedStatement() {
		InventoryManager jdbc = new InventoryManager();
		jdbc.connectDB("localhost:3306","mysql","testadmin", "passw0rd");
		jdbc.createTables();
		jdbc.addSupplierList("suppliers.txt");
		jdbc.addItemList("items.txt");
		jdbc.selectFromItems();
		jdbc.selectFromSuppliers();
		System.out.println("Searching table for tool 1002: should return 'Grommets'");
		jdbc.searchForToolID(1002);
		System.out.println("Searching table for tool 9000: should fail to find a tool");
		jdbc.searchForToolID(9000);
		jdbc.removeTables();
		jdbc.close();
		System.out.println("The program is finished running");
	}

	public static void main(String args[])
	{
		int mode = 1;
		switch(mode){
			case 0:
				mainUsingStatement();
				break;
			case 1:
				mainUsingPreparedStatement();
				break;
			default:
				break;
		}

	}
}
