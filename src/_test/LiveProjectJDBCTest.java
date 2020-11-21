import com.fasterxml.jackson.core.JsonProcessingException;
import liveops.classes.JDBCAdminRoutines;
import org.junit.Test;
import server.controller.JDBC;

import java.sql.SQLException;

public class LiveProjectJDBCTest {
    public static void main(String[] args) throws SQLException, JsonProcessingException {
    }

    @Test
    public void createTablesTest() {
        JDBCAdminRoutines setup = new JDBCAdminRoutines();
        setup.connectDB("18.236.191.241:3306","ToolShop","testadmin", "passw0rd");
        setup.query("use ToolShop;");
        setup.createAllTables();
//        setup.dropAllTables();
    }

    @Test
    public void getOrderListTest() throws JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getOrderList());
    }

    @Test
    public void getCustomersListTest() throws SQLException, JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getCustomersList());
    }

    @Test
    public void getItemsListTest() throws JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getItemsList());
    }

    @Test
    public void getSuppliersListTest() throws JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getSuppliersList());
    }

    @Test
    public void checkInventoryTest() throws SQLException, JsonProcessingException {
        JDBC jdbc = getJdbc();
        jdbc.checkInventory();
    }

    @Test
    public void insertIntoCLIENTTest() throws SQLException, JsonProcessingException {
        JDBC jdbc = getJdbc();
        jdbc.insertIntoTOOL("1094","Test Tool", "Electric","20","150", "8022");
    }

    /**
     * Test Setup
     * @return
     */
    private static JDBC getJdbc() {
        JDBC jdbc = new JDBC();
        jdbc.connectDB("18.236.191.241:3306", "ToolShop", "testadmin", "passw0rd");
        jdbc.query("use ToolShop;");
        return jdbc;
    }




}
