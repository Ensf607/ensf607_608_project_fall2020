package test;

import server.JDBC;

class JDBCTest {
    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.connectDB("localhost:3306","mysql","testadmin", "passw0rd");
        jdbc.selectWithWildCard("items","description_name","Wi%");
    }
}