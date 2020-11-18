/**
 * 
 */
package test;

/**
 * note: this code has been merged into JDBC.java
 * - Stan
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;


/**
 * @author zchem
 *
 */
public class FillDB {
	private PreparedStatement preparedStmt;
	private Statement stmt;
	private Connection con;
	private BufferedReader reader;

	public void connectDB(String host, String dbname, String username, String password) {
//        Path filePath = Paths.get(Paths.get(System.getProperty("user.dir")).toString(),host, dbname);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String url = "jdbc:mysql://" + host + "/" + dbname;

		System.out.println(ts + " log: " + "a db connection is about to be made to: \t" + url);
//                + filePath;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println(ts + " log: " + "The driver name is " + meta.getDriverName());
				System.out.println(ts + " log: " + "Tested connection successful");
				this.con = conn; // set this.conn to conn if successful
				this.stmt = con.createStatement();
				createTables();
				addSupplierList("suppliers.txt");
				addItemList("Items.txt");
				// Just pass the connection and the table name to printTable()
				DBTablePrinter.printTable(conn, "suppliers");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	


	private void createTables() {
		try {
//			stmt.executeUpdate("drop table if exists  suppliers");
//			stmt.executeUpdate("create table suppliers" + "   ( id int auto_increment," + "    company_name text null,"
//					+ "    address text null," + "    sales_contact text null," + "    constraint suppliers_pk"
//					+ "        primary key (id))");
			stmt.executeUpdate("drop table if exists  items");
			stmt.executeUpdate("create table items (" + "id int auto_increment," + "description_name text null,"
					+ "quantity_in_stock int null," + "price float null,"+ "supplier_id int null," + "primary key (id)," 
					+ "foreign key (supplier_id) references suppliers (id)" + "on update cascade on delete set null)");

		} catch (Exception e) {
			System.err.println("Cant drop/create tables");
			return;
		}
	}

	public void addItemList(String fileName) {

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
					preparedStmt = con.prepareStatement(query);
					preparedStmt.setInt(1, id);
					preparedStmt.setString(2, description);
					preparedStmt.setInt(3, quantity);
					preparedStmt.setFloat(4, price);
					preparedStmt.setInt(5, supplierId);
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

	}
	
	public void addSupplierList(String fileName) {

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
					preparedStmt = con.prepareStatement(query);
					preparedStmt.setInt(1, id);
					preparedStmt.setString(2, company_name);
					preparedStmt.setString(3, adress);
					preparedStmt.setString(4, contact);
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

	}

	public void close() {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {

		FillDB fill = new FillDB();
		fill.connectDB("localhost:3306", "tool_shop", "testadmin", "passw0rd");

	}

}
