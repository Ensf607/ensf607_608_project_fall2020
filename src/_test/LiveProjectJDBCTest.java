import com.fasterxml.jackson.core.JsonProcessingException;
import liveops.classes.JDBCAdminRoutines;
import org.junit.Test;
import server.controller.JDBC;

import java.sql.SQLException;

public class LiveProjectJDBCTest {
    public static void main(String[] args) throws SQLException, JsonProcessingException {
//        createTablesTest();
        customerListTooJsonTest();
    }

    @Test
    private static void createTablesTest() {
        JDBCAdminRoutines setup = new JDBCAdminRoutines();
        setup.connectDB("18.236.191.241:3306","ToolShop","testadmin", "passw0rd");
        setup.query("use ToolShop;");
        setup.createAllTables();
//        setup.dropAllTables();
    }

    @Test
    private static void customerListTooJsonTest() throws SQLException, JsonProcessingException {
        JDBC jdbc = new JDBCAdminRoutines();
        jdbc.connectDB("18.236.191.241:3306","ToolShop","testadmin", "passw0rd");
        jdbc.query("use ToolShop;");
        jdbc.getOrderList();
        jdbc.toJsonCustomerList();
    }






}
