package server.model;

/**
 * The type Residential.
 */
public class Residential extends Customer{

    /**
     * Instantiates a new Residential.
     *
     * @param clientID    the client id
     * @param firstName   the first name
     * @param lastName    the last name
     * @param address     the address
     * @param postolCode  the postol code
     * @param phoneNumber the phone number
     * @param clientType  the client type
     */
    public Residential(int clientID, String firstName, String lastName, String address, String postolCode, String phoneNumber, String clientType) {
        super(clientID, firstName, lastName, clientType, phoneNumber, address, postolCode);
    }
}
