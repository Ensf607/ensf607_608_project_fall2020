package model;

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
	private String supplierAddress;
	private String salesPerson;
	private ArrayList<Item> itemArrayList = new ArrayList<Item>();

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
