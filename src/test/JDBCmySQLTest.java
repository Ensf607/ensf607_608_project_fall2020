package test;

import controller.JDBC;

class JDBCmySQLTest {
    public static void main(String[] args) {
        JDBC test = new JDBC();
        test.connectDB("localhost:3306","mysql","testadmin", "passw0rd");
    }
}