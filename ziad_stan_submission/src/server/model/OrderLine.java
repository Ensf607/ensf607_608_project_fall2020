package server.model;

/**
 * The type Order line.
 *
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class OrderLine {
	private int orderID;
	private int toolID;
	private int supplierID;
	private int amount;

	private Item item;

	private String itemName;
	private String supplierName;

    /**
     * Instantiates a new Order line.
     */
    public OrderLine() {

	}

    /**
     * Instantiates a new Order line.
     *
     * @param orderID    the order id
     * @param toolID     the tool id
     * @param supplierID the supplier id
     * @param amount     the amount
     */
    public OrderLine(int orderID, int toolID, int supplierID, int amount) {
		this.orderID = orderID;
		this.toolID = toolID;
		this.supplierID = supplierID;
		this.amount = amount;
	}

    /**
     * Gets supplier id.
     *
     * @return the supplier id
     */
    public int getSupplierID() {
		return supplierID;
	}

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderID() {
		return orderID;
	}

    /**
     * Gets tool id.
     *
     * @return the tool id
     */
    public int getToolID() {
		return toolID;
	}

    /**
     * Sets order id.
     *
     * @param orderID the order id
     */
    public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

    /**
     * Sets supplier id.
     *
     * @param supplierID the supplier id
     */
    public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(int amount) {
		this.amount = amount;
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
     * Sets supplier name.
     *
     * @param supplierName the supplier name
     */
    public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

    /**
     * Sets tool id.
     *
     * @param toolID the tool id
     */
    public void setToolID(int toolID) {
		this.toolID = toolID;
	}

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
