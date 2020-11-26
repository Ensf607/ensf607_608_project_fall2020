package liveops.classes;

import server.controller.JDBC;

/**
 * The type Jdbc admin routines.
 */
public class JDBCAdminRoutines extends JDBC {
    /**
     * Create all tables.
     */
    public void createAllTables(){
        createSupplier();
        createTool();
        createClient();
        createOrder();
        createOrderline();
        createPurchase();
        createElectrical();
        createInternational();
        System.out.println("all tables are created.");
    }

    private void createInternational() {
        query("create table INTERNATIONAL\n" +
                "(\n" +
                "\tSupplierID int not null,\n" +
                "\tImportTax float null,\n" +
                "\tconstraint INTERNATIONAL_pk\n" +
                "\t\tprimary key (SupplierID),\n" +
                "\tconstraint INTERNATIONAL_SUPPLIER_SupplierID_fk\n" +
                "\t\tforeign key (SupplierID) references SUPPLIER (SupplierID)\n" +
                "\t\t\ton update cascade\n" +
                ");\n" +
                "\n");
    }

    private void createElectrical() {
        query("create table ELECTRICAL\n" +
                "(\n" +
                "\tToolID int not null,\n" +
                "\tPowerType varchar(20) null,\n" +
                "\tconstraint ELECTRICAL_pk\n" +
                "\t\tprimary key (ToolID),\n" +
                "\tconstraint ELECTRICAL_TOOL_ToolID_fk\n" +
                "\t\tforeign key (ToolID) references TOOL (ToolID)\n" +
                "\t\t\ton update cascade\n" +
                ");");
    }

    private void createPurchase() {
        query("create table PURCHASE\n" +
                "(\n" +
                "\tClientID int not null,\n" +
                "\tToolID int not null,\n" +
                "\tDate TIMESTAMP not null,\n" +
                "\tconstraint PURCHASE_pk\n" +
                "\t\tprimary key (ClientID, ToolID, Date),\n" +
                "\tconstraint PURCHASE_CLIENT_ClientID_fk\n" +
                "\t\tforeign key (ClientID) references CLIENT (ClientID)\n" +
                "\t\t\ton update cascade,\n" +
                "\tconstraint PURCHASE_TOOL_ToolID_fk\n" +
                "\t\tforeign key (ToolID) references TOOL (ToolID)\n" +
                "\t\t\ton update cascade\n" +
                ");\n" +
                "\n");
    }

    private void createOrderline() {
        query("create table ORDERLINE\n" +
                "(\n" +
                "\tOrderID int not null,\n" +
                "\tToolID int not null,\n" +
                "\tSupplierID int not null,\n" +
                "\tQuantity int null,\n" +
                "\tconstraint ORDERLINE_pk\n" +
                "\t\tprimary key (OrderID, ToolID),\n" +
                "\tconstraint ORDERLINE_ORDER__OrderID_fk\n" +
                "\t\tforeign key (OrderID) references ORDER_ (OrderID)\n" +
                "\t\t\ton update cascade,\n" +
                "\tconstraint ORDERLINE_SUPPLIER_SupplierID_fk\n" +
                "\t\tforeign key (SupplierID) references SUPPLIER (SupplierID)\n" +
                "\t\t\ton update cascade,\n" +
                "\tconstraint ORDERLINE_TOOL_ToolID_fk\n" +
                "\t\tforeign key (ToolID) references TOOL (ToolID)\n" +
                "\t\t\ton update cascade\n" +
                ");\n" +
                "\n");
    }

    private void createOrder() {
        query("create table ORDER_\n" +
                "(\n" +
                "\tOrderID int auto_increment,\n" +
                "\tDate TIMESTAMP null,\n" +
                "\tconstraint ORDER__pk\n" +
                "\t\tprimary key (OrderID)\n" +
                ");\n");
    }

    private void createClient() {
        query("create table CLIENT\n" +
                "(\n" +
                "\tClientID int auto_increment,\n" +
                "\tLName varchar(50) null,\n" +
                "\tFName varchar(50) null,\n" +
                "\tType varchar(20) null,\n" +
                "\tPhoneNum varchar(10) null,\n" +
                "\tAddress text null,\n" +
                "\tPostalCode varchar(20) null,\n" +
                "\tconstraint CLIENT_pk\n" +
                "\t\tprimary key (ClientID)\n" +
                ");\n" +
                "\n");
    }

    /**
     * Refresh schema.
     */
    public void refreshSchema(){
        query("drop schema if exists ToolShop;");
        query("create schema ToolShop;");
    }

    /**
     * drop tables in proper orders
     */
    public void dropAllTables(){
        query("drop table if exists INTERNATIONAL;");
        query("drop table if exists ELECTRICAL;");
        query("drop table if exists PURCHASE;");
        query("drop table if exists ORDERLINE;");
        query("drop table if exists ORDER_;");
        query("drop table if exists CLIENT;");
        query("drop table if exists TOOL;");
        query("drop table if exists SUPPLIER;");
        System.out.println("all tables are dropped.");
    }

    private void createSupplier(){
        query("create table SUPPLIER\n" +
                "(\n" +
                "\tSupplierID int auto_increment,\n" +
                "\tName varchar(50) null,\n" +
                "\tType varchar(20) null,\n" +
                "\tAddress text null,\n" +
                "\tCName varchar(50) null,\n" +
                "\tPhone varchar(10) null,\n" +
                "\tconstraint SUPPLIER_pk\n" +
                "\t\tprimary key (SupplierID)\n" +
                ");");
    }

    private void createTool() {
        query("create table TOOL\n" +
                "(\n" +
                "\tToolID int auto_increment,\n" +
                "\tName varchar(50) null,\n" +
                "\tQuantity int null,\n" +
                "\tPrice float null,\n" +
                "\tSupplierID int null,\n" +
                "\tconstraint TOOL_pk\n" +
                "\t\tprimary key (ToolID),\n" +
                "\tconstraint TOOL_SUPPLIER_SupplierID_fk\n" +
                "\t\tforeign key (SupplierID) references SUPPLIER (SupplierID)\n" +
                ");");
    }

}
