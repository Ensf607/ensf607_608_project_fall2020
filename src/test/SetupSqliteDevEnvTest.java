package test;
import static devops.SetupSqliteDevEnv.createDB;

public class SetupSqliteDevEnvTest {
    public static void main(String[] args) {
        createDB("localDB","test.db");
    }
}
