import server.controller.JDBCAdminRoutines;

public class LiveProjectJDBCTest {
    public static void main(String[] args) {
        JDBCAdminRoutines setup = new JDBCAdminRoutines();
        setup.connectDB("18.236.191.241:3306","ToolShop","testadmin", "passw0rd");
        setup.query("use ToolShop;");
        setup.createAllTables();
//        setup.dropAllTables();
    }
}
