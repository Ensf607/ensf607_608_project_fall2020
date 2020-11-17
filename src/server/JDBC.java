package server;

import server.jdo.Shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.MessageFormat;


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


    public void setConn(Connection conn) {
        this.conn = conn;
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
//        Path filePath = Paths.get(Paths.get(System.getProperty("user.dir")).toString(),host, dbname);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String url = "jdbc:mysql://"+host+"/"+dbname;

        System.out.println(ts
                +" log: "
                +"a db connection is about to be made to: \t"
                + url);
//                + filePath;
        try (Connection conn = DriverManager.getConnection(url,username,password)) {
            setConn(DriverManager.getConnection(url,username,password));
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println(ts +" log: " +
                        "The driver name is " + meta.getDriverName());
                System.out.println(ts +" log: " +
                        "Tested connection successful");
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
     * D2L provided code
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

    public void selectWithWildCard(String table, String column,String strWithWildcard){
        try {
            query("use tool_shop;");
            String query = "select * from " +
                    table +
                    " where " +
                    column +
                    " like ?; ";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setString(1, strWithWildcard);
            System.out.print(pStat);
            rs = pStat.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("description_name"));
            }
            pStat.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
                    preparedStmt = conn.prepareStatement(query);
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
                    preparedStmt = conn.prepareStatement(query);
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

    // TODO: make ingest supplier to ingest from mysql;
    void ingestSuppliers(Shop shop) {
//        Scanner scanLine= new Scanner(returnData());
//        if (scanLine.hasNextLine()) {
//            do {
//                String[] readLine = scanLine.nextLine().split(";");
//                Supplier parseSupplier = new Supplier();
//                parseSupplier.setId(Integer.parseInt(readLine[0]));
//                parseSupplier.setSupplierName(readLine[1]);
//                parseSupplier.setSupplierAddress(readLine[2]);
//                parseSupplier.setSalesPerson(readLine[3]);
//                shop.getSupplierList().appendToSupplierList(parseSupplier);
//            } while (scanLine.hasNextLine());
//        }
//        scanLine.close();
    }


    // TODO: make ingest items to ingest from mysql;
    /**
     * ingest the items from file
     * @param shop
     *
     */
    void ingestItems(Shop shop) {
//        Scanner scanLine= new Scanner(returnData());
//        if (scanLine.hasNextLine()) {
//            do {
//                String[] readLine = scanLine.nextLine().split(";");
//                Item parseItem = new Item();
//                parseItem.setItemID(Integer.parseInt(readLine[0]));
//                parseItem.setItemName(readLine[1]);
//                parseItem.setQuantity(Integer.parseInt(readLine[2]));
//                parseItem.setPrice(Double.parseDouble(readLine[3]));
//                parseItem.setSupplierId(Integer.parseInt(readLine[4]));
//                shop.getItemList().addItem(parseItem);
//            } while (scanLine.hasNextLine());
//        }
//        scanLine.close();
    }


    /**
     * D2L provided code
     * The entry point of application.
     * @param args the input arguments
     */
   // public static void main(String[] args) {
//        MyJDBCApp app = new MyJDBCApp();
//        app.initializeConnection();
  //  }

	
}
