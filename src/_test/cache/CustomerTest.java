package _test.cache;

import server.model.Customer;

/**
 * to see a code snippet of how it's done
 * https://blog.codota.com/how-to-convert-a-java-object-into-a-json-string/
 */
public class CustomerTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Customer testCustomer = new Customer(01,"Jason",
                "Lol",
                "1234 Campus Drive",
                "T9X5X4",
                "468-854-6548",
                "International");

        testCustomer.toJSON();
    }


}
