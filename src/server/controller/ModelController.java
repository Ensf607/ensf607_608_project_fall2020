<<<<<<< HEAD
package server.controller;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

import com.fasterxml.jackson.core.JsonProcessingException;
import server.model.Shop;

public class ModelController implements Runnable{
    private ResultSet rs;
	ServerController server;
	Shop shop;
	JDBC jdbc;
	poolThread thread;

	public ModelController(ServerController server) throws IOException {
		this.server=server;
		jdbc=new JDBC();
		this.thread=new poolThread(server.getaSocket());
	}

	@Override
	public void run() {
		while(true) {
			String request = "";
			String response = "";
			try {
				request = thread.stdIn();
				System.out.println("client request: "+request);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Request r = new Request();
			try {
				response = r.requestHandler(request);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			thread.stdOut(response);


//			System.out.println("model controller running");
			sleep(100);
		}
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class poolThread {
	private final PrintWriter socketOut;
	/**
	 * The A socket.
	 */
	private final Socket aSocket;
	/**
	 * The Std in.
	 */
	private final BufferedReader stdIn;

	poolThread(Socket aSocket) throws IOException {
		this.aSocket = aSocket;
		this.stdIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
		this.socketOut = new PrintWriter(new OutputStreamWriter(aSocket.getOutputStream()), true);
	}

	public String stdIn() throws IOException {
		StringBuffer buffer = null;
		while (true) {
			if (buffer == null) {
				buffer = new StringBuffer(stdIn.readLine());
			} else {
				break;
			}
		}
		String string = buffer.toString();
		return string;
	}

	public void stdOut(String message) {
		socketOut.println(message);
	}

	public void exit(){
		socketOut.close();
		try {
			stdIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			aSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
=======
package server.controller;
import server.model.*;

public class ModelController {
    Commercial commercial;
    Customer client;
    CustomerList customerList;
    Electrical electrical;
    International international;
    Inventory inventory;
    Item item;
    Local local;
    NonElectrical nonElectrical;
    Order order;
    OrderLine orderLine;
    Purchase purchase;
    PurchaseList purchaseList;
    Residential residential;
    Shop shop;
    Supplier supplier;
    SupplierList supplierList;

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setClient(Customer client) {
        this.client = client;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setSupplierList(SupplierList supplierList) {
        this.supplierList = supplierList;
    }

    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
    }

    public void setCustomerList(CustomerList customerList) {
        this.customerList = customerList;
    }

    public void setElectrical(Electrical electrical) {
        this.electrical = electrical;
    }

    public void setInternational(International international) {
        this.international = international;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void setNonElectrical(NonElectrical nonElectrical) {
        this.nonElectrical = nonElectrical;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public void setPurchaseList(PurchaseList purchaseList) {
        this.purchaseList = purchaseList;
    }

    public void setResidential(Residential residential) {
        this.residential = residential;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Customer getClient() {
        return client;
    }

    public Item getItem() {
        return item;
    }

    public Commercial getCommercial() {
        return commercial;
    }

    public CustomerList getCustomerList() {
        return customerList;
    }

    public Electrical getElectrical() {
        return electrical;
    }

    public International getInternational() {
        return international;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Local getLocal() {
        return local;
    }

    public NonElectrical getNonElectrical() {
        return nonElectrical;
    }

    public Order getOrder() {
        return order;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public PurchaseList getPurchaseList() {
        return purchaseList;
    }

    public Residential getResidential() {
        return residential;
    }

    public Shop getShop() {
        return shop;
    }

    public SupplierList getSupplierList() {
        return supplierList;
    }

    @Override
    public String toString() {
        return "ModelController{" +
                "commercial=" + commercial +
                ", client=" + client +
                ", customerList=" + customerList +
                ", electrical=" + electrical +
                ", international=" + international +
                ", inventory=" + inventory +
                ", item=" + item +
                ", local=" + local +
                ", nonElectrical=" + nonElectrical +
                ", order=" + order +
                ", orderLine=" + orderLine +
                ", purchase=" + purchase +
                ", purchaseList=" + purchaseList +
                ", residential=" + residential +
                ", shop=" + shop +
                ", supplier=" + supplier +
                ", supplierList=" + supplierList +
                '}';
    }
}
>>>>>>> develop_ziad
