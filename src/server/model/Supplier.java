package server.model;

import java.util.ArrayList;

/**
 * The type Supplier.
 *
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class Supplier {
	private int id;
	private String supplierName;
	private String type;
	private String supplierAddress;
	private String salesPerson;
	private String phoneNumber;
	private ArrayList<Item> itemArrayList = new ArrayList<Item>();

    /**
     * Instantiates a new Supplier.
     */
    public Supplier(){}

    /**
     * Instantiates a new Supplier.
     *
     * @param id              the id
     * @param supplierName    the supplier name
     * @param type            the type
     * @param supplierAddress the supplier address
     * @param salesPerson     the sales person
     * @param phoneNumber     the phone number
     */
    public Supplier(int id, String supplierName, String type, String supplierAddress, String salesPerson, String phoneNumber) {
		this.id = id;
		this.supplierName = supplierName;
		this.type = type;
		this.supplierAddress = supplierAddress;
		this.salesPerson = salesPerson;
		this.phoneNumber = phoneNumber;
	}

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
		this.id = id;
	}

    /**
     * Sets supplier name.
     *
     * @param supplierName the supplier name
     */
    public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

    /**
     * Sets supplier address.
     *
     * @param supplierAddress the supplier address
     */
    public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

    /**
     * Sets sales person.
     *
     * @param salesPerson the sales person
     */
    public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

    /**
     * Item list append.
     *
     * @param item the item
     */
    public void itemListAppend(Item item) {
		this.itemArrayList.add(item);
	}

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
		return id;
	}

    /**
     * Gets supplier name.
     *
     * @return the supplier name
     */
    public String getSupplierName() {
		return supplierName;
	}

    /**
     * Gets supplier address.
     *
     * @return the supplier address
     */
    public String getSupplierAddress() {
		return supplierAddress;
	}

    /**
     * Gets item array list.
     *
     * @return the item array list
     */
    public ArrayList<Item> getItemArrayList() {
		return itemArrayList;
	}

    /**
     * Gets sales person.
     *
     * @return the sales person
     */
    public String getSalesPerson() {
		return salesPerson;
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
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
		return type;
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
     * Sets item array list.
     *
     * @param itemArrayList the item array list
     */
    public void setItemArrayList(ArrayList<Item> itemArrayList) {
		this.itemArrayList = itemArrayList;
	}

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String s = "Supplier{" +
				"id=" + id +
				", supplierName='" + supplierName + '\'' +
				", supplierAddress='" + supplierAddress + '\'' +
				", salesPerson='" + salesPerson + '\'' +
				", itemList=" + itemArrayList +
				'}';
		return s;
	}
}
