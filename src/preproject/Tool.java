package preproject;

/**
 * The type Tool.
 */
public class Tool extends server.model.Item{
    /**
     * Instantiates a new Tool.
     *
     * @param id         the id
     * @param name       the name
     * @param quantity   the quantity
     * @param price      the price
     * @param supplierID the supplier id
     */
    public Tool(int id, String name, int quantity, double price, int supplierID) {
        super(id, name, quantity, price, supplierID);
    }
}
