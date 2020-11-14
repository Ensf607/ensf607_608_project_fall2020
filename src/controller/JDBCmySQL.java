package controller;

import java.sql.*;


/**
 *             String path = "localhost"
 *             String fileName = "mysql.db"
 *             String username = "admin";
 *             String password = "passw0rd";
 */

public class JDBCmySQL {
    public static void connectDB(String host, String dbname, String username, String password) {
//        Path filePath = Paths.get(Paths.get(System.getProperty("user.dir")).toString(),host, dbname);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String url = "jdbc:mysql://"+host+"/"+dbname;

        System.out.println(ts
                +" log: "
                +"a db connection is about to be made to: \t"
                + url);

//                + filePath;

        try (Connection conn = DriverManager.getConnection(url,username,password)) {
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
}
