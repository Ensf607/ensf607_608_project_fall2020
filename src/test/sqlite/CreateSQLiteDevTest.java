package test.sqlite;
import static test.sqlite.CreateSQLiteDev.createDB;

public class CreateSQLiteDevTest {
    public static void main(String[] args) {
        createDB("localDB","test.db");
    }
}
