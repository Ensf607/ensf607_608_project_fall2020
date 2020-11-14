package test;

import controller.JDBCmySQL;

class JDBCmySQLTest {
    public static void main(String[] args) {
        JDBCmySQL test = new JDBCmySQL();
        test.connectDB("localhost:3306","mysql","testadmin", "passw0rd");
    }
}