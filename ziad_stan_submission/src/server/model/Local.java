package server.model;

/**
 * The type Local.
 */
public class Local extends Supplier{

    /**
     * Instantiates a new Local.
     *
     * @param id              the id
     * @param supplierName    the supplier name
     * @param type            the type
     * @param supplierAddress the supplier address
     * @param salesPerson     the sales person
     * @param phoneNumber     the phone number
     */
    public Local(int id, String supplierName, String type, String supplierAddress, String salesPerson, String phoneNumber) {
        super(id, supplierName, type, supplierAddress, salesPerson, phoneNumber);
    }
}
