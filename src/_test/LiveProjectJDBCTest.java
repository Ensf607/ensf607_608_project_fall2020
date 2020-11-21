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
    public void insertIntoTests() throws SQLException, JsonProcessingException {
        JDBC jdbc = getJdbc();
        jdbc.insertIntoCLIENT("21","Stan","Lee","Commercial","4036594568","1234 Sesame ST NE","T5J 0O3");
        jdbc.insertIntoELECTRICAL("1094", "Battery");
        jdbc.insertIntoINTERNATIONAL("8023","0.05");
        jdbc.insertIntoORDER_("27052","2020-11-20 11:24:23");
        jdbc.insertIntoORDERLINE("27052","1001","8014","15");
        jdbc.insertIntoPURCHASE("14","1001","2020-11-21 03:07:39");
        jdbc.insertIntoSUPPLIER("8024", "Stan Awesome Shop", "Local","1234 Sesame ST NW", "Stan", "4035642569");
        jdbc.insertIntoTOOL("1095","Test Tool2", "Electric","20","150", "8022");
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
