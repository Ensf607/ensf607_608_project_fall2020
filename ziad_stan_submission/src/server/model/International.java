package server.model;

/**
 * The type International.
 */
public class International extends Supplier {
    private int supplierID;
    private double importTax;

    /**
     * Instantiates a new International.
     *
     * @param id              the id
     * @param supplierName    the supplier name
     * @param type            the type
     * @param supplierAddress the supplier address
     * @param salesPerson     the sales person
     * @param phoneNumber     the phone number
     */
    public International(int id, String supplierName, String type, String supplierAddress, String salesPerson, String phoneNumber) {
        super(id, supplierName, type, supplierAddress, salesPerson, phoneNumber);
    }

    /**
     * Instantiates a new International.
     */
    public International() {

    }

    /**
     * Sets supplier id.
     *
     * @param supplierID the supplier id
     */
    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    /**
     * Sets import tax.
     *
     * @param importTax the import tax
     */
    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    /**
     * Gets supplier id.
     *
     * @return the supplier id
     */
    public int getSupplierID() {
        return supplierID;
    }

    /**
     * Gets import tax.
     *
     * @return the import tax
     */
    public double getImportTax() {
        return importTax;
    }
}
