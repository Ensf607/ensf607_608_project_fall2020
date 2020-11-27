package server.model;

/**
 * The type Commercial.
 */
public class Commercial extends Customer {

    /**
     * Instantiates a new Commercial.
     *
     * @param clientID    the client id
     * @param firstName   the first name
     * @param lastName    the last name
     * @param address     the address
     * @param postolCode  the postol code
     * @param phoneNumber the phone number
     * @param clientType  the client type
     */
    public Commercial(int clientID, String firstName, String lastName, String address, String postolCode,
			String phoneNumber, String clientType) {
		super(clientID, firstName, lastName, clientType, phoneNumber, address, postolCode);
		// TODO Auto-generated constructor stub
	}

}
