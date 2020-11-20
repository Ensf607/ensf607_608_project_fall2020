package test;

import server.controller.JDBC;

class PreProjectJDBCTest {
    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
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
        System.out.println("The program is finished running");
    }
}