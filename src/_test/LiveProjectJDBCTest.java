package _test;

import com.fasterxml.jackson.core.JsonProcessingException;
import liveops.classes.JDBCAdminRoutines;
import org.junit.Test;
import server.controller.JDBC;

import java.sql.SQLException;

/**
 * The type Live project jdbc test.
 */
public class LiveProjectJDBCTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws SQLException            the sql exception
     * @throws JsonProcessingException the json processing exception
     */
    public static void main(String[] args) throws SQLException, JsonProcessingException {
    }

    /**
     * Create tables test.
     */
    @Test
    public void createTablesTest() {
        JDBCAdminRoutines setup = new JDBCAdminRoutines();
        setup.connectDB("18.236.191.241:3306","ToolShop","testadmin", "passw0rd");
        setup.query("use ToolShop;");
        setup.createAllTables();
//        setup.dropAllTables();
    }

    /**
     * Gets order list test.
     *
     * @throws JsonProcessingException the json processing exception
     */
    @Test
    public void getOrderListTest() throws JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getOrderList());
    }

    /**
     * Gets customers list test.
     *
     * @throws SQLException            the sql exception
     * @throws JsonProcessingException the json processing exception
     */
    @Test
    public void getCustomersListTest() throws SQLException, JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getCustomersList());
    }

    /**
     * Gets items list test.
     *
     * @throws JsonProcessingException the json processing exception
     */
    @Test
    public void getItemsListTest() throws JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getItemsList());
    }

    /**
     * Gets suppliers list test.
     *
     * @throws JsonProcessingException the json processing exception
     */
    @Test
    public void getSuppliersListTest() throws JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getSuppliersList());
    }

    /**
     * Check inventory test.
     *
     * @throws SQLException            the sql exception
     * @throws JsonProcessingException the json processing exception
     */
    @Test
    public void checkInventoryTest() throws SQLException, JsonProcessingException {
        JDBC jdbc = getJdbc();
        jdbc.checkInventory();
    }

    /**
     * Insert into tests.
     *
     * @throws SQLException            the sql exception
     * @throws JsonProcessingException the json processing exception
     */
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
     * Gets search result test.
     *
     * @throws JsonProcessingException the json processing exception
     */
    @Test
    public void getSearchResultTest() throws JsonProcessingException {
        JDBC jdbc = getJdbc();
        System.out.println(jdbc.getSearchResult("TOOL","ToolID","1095"));
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
