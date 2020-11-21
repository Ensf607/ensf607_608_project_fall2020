package server.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * The type Order.
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class Order {

	private String orderDate = Calendar.getInstance().getTime().toString();
	private ArrayList <OrderLine> orderLineArrayList = new ArrayList <OrderLine>();

	/**
	 * Sets date.
	 */
	public void setDate() {
		Date today = Calendar.getInstance().getTime();
		this.orderDate = today.toString();
	}

	/**
	 * Check item.
	 *
	 * @param itemCheck the item to check
	 */
	public void checkItem(Item itemCheck) {
		OrderLine orderLine = new OrderLine();
		orderLine.setItem(itemCheck);
		orderLine.setAmount();
		orderLine.setItemName();
		orderLine.setSupplierName();
		this.orderLineArrayList.add(orderLine);
	}

	/**
	 * Gets order date.
	 *
	 * @return the order date
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * Generate order id int.
	 *
	 * @return the int
	 */
	public int generateOrderID(){
		Random r = new Random( System.currentTimeMillis() );
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}


	/**
	 * Gets order line array list.
	 *
	 * @return the order line array list
	 */
	public ArrayList<OrderLine> getOrderLineArrayList() {
		return orderLineArrayList;
	}


	@Override
	public String toString() {
		String s = "**********************************************************************";
		for(int i = 0; i< orderLineArrayList.size(); i++) {
			s+="\nORDER ID:\t\t\t"+(generateOrderID()+i);
			s+="\nDate Ordered:\t\t"+ orderDate +"\n\n";
			s+= orderLineArrayList.get(i).toString();
			s+="**********************************************************************";
		}
		return s;
	}
}
