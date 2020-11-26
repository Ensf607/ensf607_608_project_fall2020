package server.model;

/**
 * The type Electrical.
 */
public class Electrical extends Item{
    private int toolID;
    private String powerType;

    /**
     * Instantiates a new Electrical.
     *
     * @param id         the id
     * @param name       the name
     * @param quantity   the quantity
     * @param price      the price
     * @param supplierID the supplier id
     */
    public Electrical(int id, String name, int quantity, double price, int supplierID) {
        super(id, name, quantity, price, supplierID);
    }

    /**
     * Instantiates a new Electrical.
     */
    public Electrical() {

    }

    /**
     * Sets tool id.
     *
     * @param toolID the tool id
     */
    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

    /**
     * Gets tool id.
     *
     * @return the tool id
     */
    public int getToolID() {
        return toolID;
    }

    /**
     * Sets power type.
     *
     * @param powerType the power type
     */
    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    /**
     * Gets power type.
     *
     * @return the power type
     */
    public String getPowerType() {
        return powerType;
    }


}
