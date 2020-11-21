package model;

/**
 * The type Order line.
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class OrderLine {
	private Item item;
	private String itemName;
	private int amount;
	private String supplierName;

	/**
	 * Sets item.
	 *
	 * @param item the item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Gets item.
	 *
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Sets item name.
	 */
	public void setItemName() {
		this.itemName = item.getItemName();
	}

	/**
	 * Gets item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets amount.
	 */
	public void setAmount() {
		this.amount = 50-item.getQuantity();
	}

	/**
	 * Gets amount.
	 *
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets supplier name.
	 */
	public void setSupplierName() {
		this.supplierName = item.getSupplier().getSupplierName();
	}

	/**
	 * Gets supplier name.
	 *
	 * @return the supplier name
	 */
	public String getSupplierName() {
		return supplierName;
	}

	@Override
	public String toString() {
		String s = "Item description:\t"+itemName+"\n"+"Amount ordered:\t\t"+amount+"\n"+"Supplier:\t\t\t"+supplierName+"\n";
		return s;
	}
}
