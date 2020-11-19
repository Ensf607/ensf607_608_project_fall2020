package server.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
//TODO :
//Query for Listing all tools
//Query for search by toolName
//Query for search by toolID
//Query for purchasing an item (need to include customer info ???)

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    String json = new String();
    ObjectNode node;

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

    public ResultSet getItemsList(){
        try {
            String table = "items";
            query("use tool_shop;");
            String query = "select * from " +
                    table;
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet getCustomersList() {
        try {
            String table = "customer";
            query("use tool_shop;");
            String query = "select * from " +
                    table;
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getSuppliersList(){
        try {
            String table = "suppliers";
            query("use tool_shop;");
            String query = "select * from " +
                    table;
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            }         
         catch (SQLException e) {
            e.printStackTrace();
        }
       return rs;
    }

    public ResultSet searchForToolID(int toolID){
        return searchGeneralPurpose("items","id", String.valueOf(toolID));
    }
    public ResultSet searchForToolName(String toolName){
        return searchGeneralPurpose("items","description_name", toolName);
    }
    public ResultSet checkInventory() {
    	try {
            String table = "items";
            query("use tool_shop;");
            String query = "SELECT id,quantity_in_stock,supplier_id FROM "+table+" WHERE quantity_in_stock < ?";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, 40);
            rs=pStat.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
         //  System.out.println( metaData.getColumnType(1));
            node = new ObjectMapper().createObjectNode();
            System.out.println(rs.getString(1));
            node.put(metaData.getColumnName(1), rs.getInt(1));
//            for (int i=1 ;i<=metaData.getColumnCount();i++)
//            {	System.out.println(metaData.getColumnName(i)+" "+rs.getString(i));
//            	node.put(metaData.getColumnName(i), rs.getString(i));
//            }
            System.err.println(node.toString());
     //       pStat.close();
            }catch (SQLException e) {
            	System.out.println(e);
            }
    	return rs;
    }
    public void purchase (int toolID, int quantity,int customerID)
    {
    	 try {
             String table = "items";
             query("use tool_shop;");
             String query = "UPDATE "+ table +" SET quantity_in_stock=quantity_in_stock-? WHERE id=?";
             PreparedStatement pStat = conn.prepareStatement(query);
             pStat.setInt(1, quantity);
             pStat.setInt(2, toolID);
             int n=pStat.executeUpdate();
             System.out.println(n);
             }         
          catch (SQLException e) {
             e.printStackTrace();
         }
    }
    


}
	


		




