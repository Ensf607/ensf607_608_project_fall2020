package controller;

import java.sql.*;
import java.text.MessageFormat;


/**
 * String path = "localhost"
 * String fileName = "mysql.db"
 * String username = "admin";
 * String password = "passw0rd";
 */
public class JDBC {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

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


    public void query(String sql){
        try (Statement stmt = conn.createStatement()) {
//            System.out.println("Querying: \n" +
//                    "----------"+sql+"\n----------");
            stmt.executeUpdate(sql);
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

    /**
     * D2L provided code
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
//        MyJDBCApp app = new MyJDBCApp();
//        app.initializeConnection();
    }

}
