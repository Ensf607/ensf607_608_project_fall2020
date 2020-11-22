package server.model;

/**
 * The type Item.
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class Item {
	private int itemID;
	private String itemName;
	private int quantity;
	private double price;
	private int supplierId;
	private Supplier supplier;

    public Item(int parseInt, String s, int parseInt1, double parseDouble, int parseInt2) {
    	this.itemID=parseInt;
    	this.itemName=s;
    	this.quantity=parseInt;
    	this.price=parseDouble;
    	this.supplierId=parseInt2;
    }

    /**
	 * Sets item id.
	 *
	 * @param itemID the item id
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	/**
	 * Gets item id.
	 *
	 * @return the item id
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * Sets item name.
	 *
	 * @param itemName the item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	 * Sets quantity.
	 *
	 * @param quantity the quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets price.
	 *
	 * @param price the price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets supplier id.
	 *
	 * @param id the id
	 */
	public void setSupplierId(int id) {
		this.supplierId = id;
	}

	/**
	 * Gets supplier id.
	 *
	 * @return the supplier id
	 */
	public int getSupplierId() {
		return supplierId;
	}

	/**
	 * Sets supplier.
	 *
	 * @param supplier the sup
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Gets supplier.
	 *
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * Decrease quantity.
	 *
	 * @param n the n
	 */
	public void decreaseQuantity(int n) {
		this.quantity-=n;
	}

	/**
	 * Increase quantity.
	 *
	 * @param n the n
	 */
	public void increaseQuantity(int n) {
		this.quantity+=n;
	}


	@Override
	public String toString() {
		String s = "Item ID:\t\t" +
				itemID + "\nName of Tool:\t" +
				itemName + "\nPrice:\t\t\t$" +
				price + "\nSupplier ID:\t" +
				supplierId;
		return s;
	}
}
