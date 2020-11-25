package server.model;

public class Residential extends Customer{

    public Residential(int clientID, String firstName, String lastName, String address, String postolCode, String phoneNumber, String clientType) {
        super(clientID, firstName, lastName, clientType, phoneNumber, address, postolCode);
    }
}
