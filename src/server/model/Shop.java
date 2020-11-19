package server.model;

import java.io.FileNotFoundException;
import java.sql.ResultSet;

/**
 * The type Shop.
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class Shop {
	private Inventory inventory ;
	private SupplierList supplierList;
	private CustomerList customerList;
	private PurchaseList pl;
	//need a method to checkItems,
	//return order which is (list ofOrderLine)
	/**
	 * Gets item list.
	 *
	 * @return the item list
	 */
	public Shop (ResultSet customers,ResultSet itemList,ResultSet suppliers,ResultSet orderList, ResultSet purchaseList) {
		inventory=new Inventory(itemList, orderList);
		supplierList=new SupplierList(suppliers);
		customerList=new CustomerList(customers);
		pl=new PurchaseList(purchaseList);
	}
	public Inventory getinventory() {
		return inventory;
	}

	/**
	 * Gets supplier list.
	 *
	 * @return the supplier list
	 */
	public SupplierList getSupplierList() {
		return supplierList;
	}

//	/**
//	 * Instantiates a new Shop.
//	 */
//	public Shop(String itemsPath, String supplierPath){
//		try {
//			ingestListData(itemsPath,supplierPath);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	// TODO: make this method to ingest data from mysql instead,
	//  this may need to be modified if it's more suitable to query from db directly.

	/**
	 * Ingest list data.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public void ingestListData(String itemsPath, String supplierPath) throws FileNotFoundException {
//		FileManager file = new FileManager();
////		itemsPath="TextFiles/items.txt";
//		file.readFileFromPath(itemsPath);
//		file.ingestItems(this);
////		supplierPath = "TextFiles/suppliers.txt";
//		file.readFileFromPath(supplierPath);
//		file.ingestSuppliers(this);
//		processReferences();

	}

	/**
	 * process references of the lists
	 */
	private void processReferences() {
		int iItem = 0 ;
		int iSupplier = 0;


		while (iItem < inventory.getItemsList().size()) {
			iSupplier = 0;
			while (iSupplier < supplierList.getSupplierList().size()) {
				if(inventory.getItemsList().get(iItem).getSupplierId() == supplierList.getSupplierList().get(iSupplier).getId()) {
				inventory.getItemsList().get(iItem).setSupplier(supplierList.getSupplierList().get(iSupplier));
				}
				iSupplier++;
			}
			iItem++;
		}

	}

}
