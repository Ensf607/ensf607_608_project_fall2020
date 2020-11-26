//package test;
import liveops.classes.JDBCPreProject;

import server.controller.JDBC;

/**
 * The type Pre project jdbc test.
 */
class PreProjectJDBCTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        preProjectJDBCDemo();
    }

    private static void preProjectJDBCDemo() {
        JDBCPreProject jdbc = new JDBCPreProject();
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