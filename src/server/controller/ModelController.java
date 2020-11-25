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
