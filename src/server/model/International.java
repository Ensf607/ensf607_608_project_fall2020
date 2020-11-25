package server.model;

public class International extends Supplier {
    private int supplierID;
    private double importTax;

    public International(int id, String supplierName, String type, String supplierAddress, String salesPerson, String phoneNumber) {
        super(id, supplierName, type, supplierAddress, salesPerson, phoneNumber);
    }

    public International() {

    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public double getImportTax() {
        return importTax;
    }
}
