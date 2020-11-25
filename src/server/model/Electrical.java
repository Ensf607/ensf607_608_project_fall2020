package server.model;

public class Electrical extends Item{
    private int toolID;
    private String powerType;
    public Electrical(int id, String name, int quantity, double price, int supplierID) {
        super(id, name, quantity, price, supplierID);
    }

    public Electrical() {

    }

    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

    public int getToolID() {
        return toolID;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public String getPowerType() {
        return powerType;
    }


}
