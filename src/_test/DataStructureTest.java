package _test;


import org.junit.Test;
import server.model.Customer;

/**
 * to see a code snippet of how it's done
 * https://blog.codota.com/how-to-convert-a-java-object-into-a-json-string/
 */
public class DataStructureTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
    }

    /**
     * Customer test.
     */
    @Test
    public void customerTest() {
        Customer c = new Customer(01,"Jason",
                "Lol",
                "International", "468-854-6548", "1234 Campus Drive",
                "T9X5X4"
        );

        c.toJSON();
    }


}
