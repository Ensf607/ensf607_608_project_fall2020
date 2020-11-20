package server.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
//TODO :
//Query for Listing all tools
//Query for search by toolName
//Query for search by toolID
//Query for purchasing an item (need to include customer info ???)
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * String path = "localhost"
 * String fileName = "mysql.db"
 * String username = "admin";
 * String password = "passw0rd";
 */
public class JDBC {

    private PreparedStatement preparedStmt;
    private Statement stmt;
    private Connection conn;
    private ResultSet rs;
    private BufferedReader reader;
    private String json = new String();
    private ResultSetMetaData metaData;

    public Connection getConn() {
		return conn;
	}
 
	public void setConn(Connection conn) {
        this.conn = conn;
    }
public JDBC() {
	connectDB("18.236.191.241:3306", "tool_shop", "testadmin", "passw0rd");
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
            setConn(DriverManager.getConnection(url,username,password));
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println(ts+"\nConnected to: "+url);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void query(String sql){
        try (Statement stmt = conn.createStatement()) {
//            System.out.println("Querying: \n" +
//                    "----------"+sql+"\n----------");
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * D2L provided code
     * close()
     */
    public void close() {
        try {
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    /**
     * Might create a User table that contains login info in Mysql
     * Select user.
     */
    public void selectUser() {
        try {
            stmt = conn.createStatement();
            String query = "SELECT * FROM USERS";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username") + " " +
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * D2L provided code
     * Insert user.
     */
    public void insertUser() {
        try {
            stmt = conn.createStatement();
            String insert = "INSERT INTO users (ID, username,password) values " +
                    "(1004, 'newUser','newPass')";
            int rowCount = stmt.executeUpdate(insert);
            System.out.println("row Count = " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * D2L provided code
     * Delete user.
     */
    public void deleteUser() {
        try {
            stmt = conn.createStatement();
            String delete = "DELETE FROM users WHERE username = 'newUser'";
            int rowCount = stmt.executeUpdate(delete);
            System.out.println("row Count = " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * D2L provided code
     * Validate login.
     *
     * @param username the username
     * @param password the password
     */
    public void validateLogin(String username, String password) {
        try {
            stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username
                    + "' and password ='" + password + "'";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println("User is logged in");
            } else {
                System.out.println("Invalid Username and Password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * D2L provided code
     * Select user prepared statement.
     */
    public void selectUserPreparedStatement() {
        try {
            String query = "SELECT * FROM users where username= ? and password =?";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setString(1, "Jackson");
            pStat.setString(2, "123456");
            rs = pStat.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("username") + " " +
                        rs.getString("password"));
            }
            pStat.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
            PreparedStatement pStat = conn.prepareStatement(query);
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

    

    public ResultSet searchGeneralPurpose(String table, String column, String strWithWildcard){
        try {
            query("use tool_shop;");
            String query = "select * from " +
                    table +
                    " where " +
                    column +
                    " like ?; ";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setString(1, strWithWildcard);
            rs = pStat.executeQuery();
          
            pStat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void displayReturnStatement(String[] columns) throws SQLException {
        for (int i = 0; i < columns.length; i++)
            System.out.print (rs.getString(columns[i])+ "\t");
    }

    public String getItemsList() throws JsonProcessingException{
        try {
            String table = "items";//include ELECTRICAL when table is created
            query("use tool_shop;");
            String query = "select * from " +
                    table;
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            metaData=rs.getMetaData();
            toolListTooJson();
            pStat.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return json;
    }
    public String getCustomersList() throws JsonProcessingException {
        try {
            String table = "customer";
            query("use tool_shop;");
            String query = "select * from " +
                    table;
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            metaData=rs.getMetaData();
            customerListTooJson();
            pStat.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return json;
    }
    
    public String getSuppliersList() throws JsonProcessingException{
        try {
            String table = "suppliers";
            query("use tool_shop;");
            String query = "select * from " +
                    table;
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            metaData=rs.getMetaData();
            supplierListTooJson();
            pStat.close();
            }         
         catch (SQLException e) {
            e.printStackTrace();
        }
       return json;
    }
    /**
     * NEED TO CHANGE
    public ResultSet searchForToolID(int toolID){
        return searchGeneralPurpose("items","id", String.valueOf(toolID));
    }
    public ResultSet searchForToolName(String toolName){
        return searchGeneralPurpose("items","description_name", toolName);
    }*/
    public void checkInventory() {
    	try {
            String table = "TOOL";
            query("use tool_shop;");
            String query = "SELECT id,quantity_in_stock,supplier_id FROM "+table+" WHERE quantity_in_stock < ?";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, 40);
            rs=pStat.executeQuery();
            if (rs!=null)
            {	int orderID=generateOrderID();
            	createOrder(orderID);
            	createOrderLine(orderID);
            	//do we update ITEM ??
            }
            pStat.close();
            }catch (SQLException e) {
            	System.out.println(e);
            }
    }
    private void createOrderLine(int orderID) {
    	try {
    	String table = "ORDERLINE";
        query("use tool_shop;");
        PreparedStatement pStat = null;
        while(rs.next()) {
        String query = "INSERT INTO"+table+"VALUES(?,?,?,?)";
        pStat = conn.prepareStatement(query);
        pStat.setInt(1, orderID);
        pStat.setInt(2, rs.getInt("ToolID"));
        pStat.setInt(3, rs.getInt("SupplierID"));
        pStat.setInt(4, (int)(50-rs.getInt("Quantity")));//assuming it creates orderline of 50
        pStat.executeUpdate();
        }
        pStat.close();
       
	}catch (SQLException e) {
		System.out.println(e);
	}
	}

	private void createOrder(int orderID) {
    	try {
            String table = "ORDER";
            query("use tool_shop;");
            String query = "INSERT INTO"+table+"VALUES(?,CURRENT_TIMESTAMP)";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, orderID);
            pStat.executeUpdate();
            pStat.close();
            
		
	}catch (SQLException e) {
		System.out.println(e);
	}
	}
    	public int generateOrderID(){
    		Random r = new Random( System.currentTimeMillis() );
    		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    	}

	public void purchase (int toolID, int quantity,int customerID)
    {
    	 try {
    		 updatePurchaseTable(toolID, customerID);
             String table = "TOOL";
             query("use tool_shop;");
             String query = "UPDATE "+ table +" SET quantity_in_stock=quantity_in_stock-? WHERE id=?";
             PreparedStatement pStat = conn.prepareStatement(query);
             pStat.setInt(1, quantity);
             pStat.setInt(2, toolID);
             int n=pStat.executeUpdate();
             checkInventory();
             pStat.close();
             
             }         
          catch (SQLException e) {
             e.printStackTrace();
         }
    }
	private void updatePurchaseTable(int toolID, int customerID) {
		 try {
             String table = "PURCHASES";
             query("use tool_shop;");
             String query = "INSERT INTO "+ table +" VALUES(?,?,CURRENT_TIMESTAMP)";
             PreparedStatement pStat = conn.prepareStatement(query);
             pStat.setInt(1, toolID);
             pStat.setInt(2, customerID);
             int n=pStat.executeUpdate();
             pStat.close();
             } catch (SQLException e) {
            	 System.out.println(e);
			}  
		 
	}

	public ResultSet generateOrder() {
		try {
            String table = "ORDER,ORDERLINE";
            query("use tool_shop;");
            String query = "SELECT * FROM "+ table ;
            PreparedStatement pStat = conn.prepareStatement(query);
            rs=pStat.executeQuery();
            }         
         catch (SQLException e) {
            e.printStackTrace();
        }
		return rs;
	}
	public void customerListTooJson() throws SQLException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		 ArrayNode arrayNode = mapper.createArrayNode();

	       while(rs.next()) {
	    	   System.err.println(metaData.getColumnName(1)+rs.getInt(1));
	    	  ObjectNode node = new ObjectMapper().createObjectNode();
	    	 node.put(metaData.getColumnName(1), rs.getInt(1));
	    	 node.put(metaData.getColumnName(2), rs.getString(2));
	    	 node.put(metaData.getColumnName(3), rs.getString(3));
	    	 node.put(metaData.getColumnName(4), rs.getString(4));
	    	 node.put(metaData.getColumnName(5), rs.getString(5));
	    	 node.put(metaData.getColumnName(6), rs.getString(6));
	    	 node.put(metaData.getColumnName(7), rs.getString(7));
	    	 arrayNode.addAll(Arrays.asList(node));
	       
	       }
	       json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
	}
	
	public void supplierListTooJson() throws SQLException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		 ArrayNode arrayNode = mapper.createArrayNode();

	       while(rs.next()) {
	    	 System.err.println(metaData.getColumnName(1)+rs.getInt(1));
	    	 ObjectNode node = new ObjectMapper().createObjectNode();
	    	 node.put(metaData.getColumnName(1), rs.getInt(1));
	    	 node.put(metaData.getColumnName(2), rs.getString(2));
	    	 node.put(metaData.getColumnName(3), rs.getString(3));
	    	 node.put(metaData.getColumnName(4), rs.getString(4));
	    	 node.put(metaData.getColumnName(5), rs.getString(5));
	    	 node.put(metaData.getColumnName(6), rs.getString(6));
	    	 arrayNode.addAll(Arrays.asList(node));
	       
	       }
	       json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
	}
	//TODO: doesnt work yet
	public void toolListTooJson() throws SQLException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		 ArrayNode arrayNode = mapper.createArrayNode();

	       while(rs.next()) {
	    	 System.err.println(metaData.getColumnName(1)+rs.getInt(1));
	    	 ObjectNode node = new ObjectMapper().createObjectNode();
	    	 node.put(metaData.getColumnName(1), rs.getInt(1));
	    	 node.put(metaData.getColumnName(2), rs.getString(2));
	    	 node.put(metaData.getColumnName(3), rs.getString(3));
	    	 node.put(metaData.getColumnName(4), rs.getString(4));
	    	 node.put(metaData.getColumnName(5), rs.getString(5));
	    	 node.put(metaData.getColumnName(6), rs.getString(6));
	    	 arrayNode.addAll(Arrays.asList(node));
	       
	       }
	       json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
	}
	
    


}
	


		




