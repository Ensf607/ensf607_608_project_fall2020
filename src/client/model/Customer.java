package client.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

/**
 * The type Customer.
 */
public class Customer {
    private int clientID;
    private String firstName;
    private String lastName;
    private String address;
    private String postolCode;
    private String phoneNumber;
    private String clientType;

    /**
     * Instantiates a new Customer.
     *
     * @param clientID    the client id
     * @param firstName   the first name
     * @param lastName    the last name
     * @param address     the address
     * @param postolCode  the postol code
     * @param phoneNumber the phone number
     * @param clientType  the client type
     */
    public Customer(int clientID, String firstName, String lastName, String address, String postolCode, String phoneNumber, String clientType) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postolCode = postolCode;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return clientID == customer.clientID &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(postolCode, customer.postolCode) &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(clientType, customer.clientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, firstName, lastName, address, postolCode, phoneNumber, clientType);
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets client id.
     *
     * @param clientID the client id
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * Sets client type.
     *
     * @param clientType the client type
     */
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets postol code.
     *
     * @param postolCode the postol code
     */
    public void setPostolCode(String postolCode) {
        this.postolCode = postolCode;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Gets client type.
     *
     * @return the client type
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets postol code.
     *
     * @return the postol code
     */
    public String getPostolCode() {
        return postolCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", postolCode='" + postolCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", clientType='" + clientType + '\'' +
                '}';
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public String toJSON(){
        String json = new String();
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(this);
            System.out.println("ResultingJSONstring = " + json);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


}
