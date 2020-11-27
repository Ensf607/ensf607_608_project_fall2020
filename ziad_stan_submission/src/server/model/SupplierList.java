package server.model;

import java.util.ArrayList;

/**
 * The type Supplier list.
 *
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class SupplierList {
	private ArrayList <Supplier>supplierList = new ArrayList <Supplier>();

    /**
     * Append to supplier list.
     *
     * @param supplier the supplier
     */
    public void appendToSupplierList(Supplier supplier) {
		this.supplierList.add(supplier);
	}

    /**
     * Gets supplier list.
     *
     * @return the supplier list
     */
    public ArrayList<Supplier> getSupplierList() {
		return supplierList;
	}

    /**
     * Sets supplier list.
     *
     * @param supplierList the supplier list
     */
    public void setSupplierList(ArrayList<Supplier> supplierList) {
		this.supplierList = supplierList;
	}
	@Override
	public String toString() {
		return "SupplierList{" +
				"supplierList=" + supplierList +
				'}';
	}
}
