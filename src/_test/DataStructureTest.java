import org.junit.Test;
import server.model.Customer;

/**
 * to see a code snippet of how it's done
 * https://blog.codota.com/how-to-convert-a-java-object-into-a-json-string/
 */
public class DataStructureTest {
    public static void main(String[] args) {
    }

    @Test
    public void customerTest() {
        Customer c = new Customer(01,"Jason",
                "Lol",
                "1234 Campus Drive",
                "T9X5X4",
                "468-854-6548",
                "International");

        c.toJSON();
    }


}
