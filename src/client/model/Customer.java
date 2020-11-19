package client.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class Customer {
    private int clientID;
    private String firstName;
    private String lastName;
    private String address;
    private String postolCode;
    private String phoneNumber;
    private String clientType;

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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPostolCode(String postolCode) {
        this.postolCode = postolCode;
    }

    public String getAddress() {
        return address;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientType() {
        return clientType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

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
