package server.model;

import java.io.FileNotFoundException;

/**
 * The type Shop.
 * @author stan chen
 * @version 1.0
 * @since Oct 13, 2020
 */
public class Shop {
	private Inventory itemList = new Inventory();
	private SupplierList supplierList =new SupplierList();

	/**
	 * Gets item list.
	 *
	 * @return the item list
	 */
	public Inventory getItemList() {
		return itemList;
	}

	/**
	 * Gets supplier list.
	 *
	 * @return the supplier list
	 */
	public SupplierList getSupplierList() {
		return supplierList;
	}

	/**
	 * Instantiates a new Shop.
	 */
	public Shop(String itemsPath, String supplierPath){
		try {
			ingestListData(itemsPath,supplierPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

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


		while (iItem < itemList.getItemsList().size()) {
			iSupplier = 0;
			while (iSupplier < supplierList.getSupplierList().size()) {
				if(itemList.getItemsList().get(iItem).getSupplierId() == supplierList.getSupplierList().get(iSupplier).getId()) {
				itemList.getItemsList().get(iItem).setSupplier(supplierList.getSupplierList().get(iSupplier));
				}
				iSupplier++;
			}
			iItem++;
		}

	}

}
