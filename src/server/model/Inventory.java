package server.model;

import java.util.ArrayList;

/**
 * The class Inventory.
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class Inventory {
	private Item item;
	private ArrayList <Item> itemsList = new ArrayList<Item>();
	private Order order =new Order();

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
	 * Add item.
	 *
	 * @param tool the tool
	 */
	public void addItem(Item tool) {
		this.itemsList.add(tool);
	}

	/**
	 * Sets order.
	 *
	 * @param order the order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Gets order.
	 *
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets item list.
	 */
	public void setItemList() {
		this.itemsList.add(item);
	}

	/**
	 * Gets items list.
	 *
	 * @return the items list
	 */
	public ArrayList<Item> getItemsList() {
		return itemsList;
	}

	/**
	 * Gets item via id.
	 *
	 * @param id the id
	 * @return the item via id
	 */
	public Item getItemViaID(int id) {
		int i=0;
		while (i< itemsList.size()) {
			if(itemsList.get(i).getItemID()==id ) {
				return itemsList.get(i);
			}
			i++;
		}
		System.err.println("Item not found.");
		return null;
	}

	/**
	 * Remove item.
	 *
	 * @param item the item
	 */
	public void removeItem(Item item) {
		int i = 0;
		while (i< itemsList.size()) {
			if(itemsList.get(i)==item ) {
				this.itemsList.remove(i);
			}
			i++;
		}

	}

	/**
	 * Gets item via item name.
	 *
	 * @param name the name
	 * @return the item via name
	 */
	public Item getItemViaName(String name) {
		int i=0;
		while (i< itemsList.size()) {
			if(itemsList.get(i).getItemName().equalsIgnoreCase(name) ) {
				return itemsList.get(i);
			}
			i++;
		}
		System.err.println("Item not found.");
		return null;
	}

	/**
	 * Reduce item quantity.
	 *
	 * @param name     the name
	 * @param quantity the quantity to reduce
	 */
	public void reduceItem(String name, int quantity) {
		int i = 0;
		while (i< itemsList.size()) {
			if(itemsList.get(i).getItemName().equalsIgnoreCase(name) ) {
				itemsList.get(i).setQuantity(itemsList.get(i).getQuantity() - quantity);
			}
			i++;
		}
	}

	/**
	 * Check item quantity.
	 */
	public void checkQuantity() {
		for(int i = 0; i< itemsList.size(); i++) {
			if(this.itemsList.get(i).getQuantity()<=40) {
				Item itemCheck = itemsList.get(i);
				this.order.checkItem(itemCheck);
			}
		}
	}


	@Override
	public String toString() {
		String s = "**********************************************************************\n";
		for(int i = 0; i< itemsList.size(); i++) {
			s+= itemsList.get(i).toString()+
					"\n**********************************************************************"+
					"\n";
		}
		return s;
	}

	
}
