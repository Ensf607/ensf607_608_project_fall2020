package server.controller;
import server.model.*;

/**
 * The type Model controller.
 */
public class ModelController {
    /**
     * The Commercial.
     */
    Commercial commercial;
    /**
     * The Client.
     */
    Customer client;
    /**
     * The Customer list.
     */
    CustomerList customerList;
    /**
     * The Electrical.
     */
    Electrical electrical;
    /**
     * The International.
     */
    International international;
    /**
     * The Inventory.
     */
    Inventory inventory;
    /**
     * The Item.
     */
    Item item;
    /**
     * The Local.
     */
    Local local;
    /**
     * The Non electrical.
     */
    NonElectrical nonElectrical;
    /**
     * The Order.
     */
    Order order;
    /**
     * The Order line.
     */
    OrderLine orderLine;
    /**
     * The Purchase.
     */
    Purchase purchase;
    /**
     * The Purchase list.
     */
    PurchaseList purchaseList;
    /**
     * The Residential.
     */
    Residential residential;
    /**
     * The Shop.
     */
    Shop shop;
    /**
     * The Supplier.
     */
    Supplier supplier;
    /**
     * The Supplier list.
     */
    SupplierList supplierList;

    /**
     * Sets supplier.
     *
     * @param supplier the supplier
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(Customer client) {
        this.client = client;
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
     * Sets supplier list.
     *
     * @param supplierList the supplier list
     */
    public void setSupplierList(SupplierList supplierList) {
        this.supplierList = supplierList;
    }

    /**
     * Sets commercial.
     *
     * @param commercial the commercial
     */
    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
    }

    /**
     * Sets customer list.
     *
     * @param customerList the customer list
     */
    public void setCustomerList(CustomerList customerList) {
        this.customerList = customerList;
    }

    /**
     * Sets electrical.
     *
     * @param electrical the electrical
     */
    public void setElectrical(Electrical electrical) {
        this.electrical = electrical;
    }

    /**
     * Sets international.
     *
     * @param international the international
     */
    public void setInternational(International international) {
        this.international = international;
    }

    /**
     * Sets inventory.
     *
     * @param inventory the inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Sets local.
     *
     * @param local the local
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Sets non electrical.
     *
     * @param nonElectrical the non electrical
     */
    public void setNonElectrical(NonElectrical nonElectrical) {
        this.nonElectrical = nonElectrical;
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
     * Sets order line.
     *
     * @param orderLine the order line
     */
    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    /**
     * Sets purchase.
     *
     * @param purchase the purchase
     */
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    /**
     * Sets purchase list.
     *
     * @param purchaseList the purchase list
     */
    public void setPurchaseList(PurchaseList purchaseList) {
        this.purchaseList = purchaseList;
    }

    /**
     * Sets residential.
     *
     * @param residential the residential
     */
    public void setResidential(Residential residential) {
        this.residential = residential;
    }

    /**
     * Sets shop.
     *
     * @param shop the shop
     */
    public void setShop(Shop shop) {
        this.shop = shop;
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
     * Gets client.
     *
     * @return the client
     */
    public Customer getClient() {
        return client;
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
     * Gets commercial.
     *
     * @return the commercial
     */
    public Commercial getCommercial() {
        return commercial;
    }

    /**
     * Gets customer list.
     *
     * @return the customer list
     */
    public CustomerList getCustomerList() {
        return customerList;
    }

    /**
     * Gets electrical.
     *
     * @return the electrical
     */
    public Electrical getElectrical() {
        return electrical;
    }

    /**
     * Gets international.
     *
     * @return the international
     */
    public International getInternational() {
        return international;
    }

    /**
     * Gets inventory.
     *
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Gets local.
     *
     * @return the local
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Gets non electrical.
     *
     * @return the non electrical
     */
    public NonElectrical getNonElectrical() {
        return nonElectrical;
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
     * Gets order line.
     *
     * @return the order line
     */
    public OrderLine getOrderLine() {
        return orderLine;
    }

    /**
     * Gets purchase.
     *
     * @return the purchase
     */
    public Purchase getPurchase() {
        return purchase;
    }

    /**
     * Gets purchase list.
     *
     * @return the purchase list
     */
    public PurchaseList getPurchaseList() {
        return purchaseList;
    }

    /**
     * Gets residential.
     *
     * @return the residential
     */
    public Residential getResidential() {
        return residential;
    }

    /**
     * Gets shop.
     *
     * @return the shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * Gets supplier list.
     *
     * @return the supplier list
     */
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
