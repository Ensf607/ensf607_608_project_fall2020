drop schema if exists ToolShopDemoDB;
create schema ToolShopDemoDB;

use ToolShopDemoDB;

create table SUPPLIER
(
    SupplierID int auto_increment
        primary key,
    Name varchar(50) null,
    Type varchar(20) null,
    Address text null,
    CName varchar(50) null,
    Phone varchar(10) null
);


create table TOOL
(
    ToolID int auto_increment
        primary key,
    Name varchar(50) null,
    Type varchar(45) null,
    Quantity int null,
    Price float null,
    SupplierID int null,
    constraint TOOL_SUPPLIER_SupplierID_fk
        foreign key (SupplierID) references SUPPLIER (SupplierID)
            on update cascade on delete restrict

);



create table ORDER_
(
    OrderID int auto_increment
        primary key,
    Date timestamp null
);

create table ORDERLINE
(
    OrderID int not null,
    ToolID int not null,
    SupplierID int not null,
    Quantity int null,
    primary key (OrderID, ToolID),
    constraint ORDERLINE_ORDER__OrderID_fk
        foreign key (OrderID) references ORDER_ (OrderID)
            on update cascade on delete restrict,
    constraint ORDERLINE_SUPPLIER_SupplierID_fk
        foreign key (SupplierID) references SUPPLIER (SupplierID)
            on update cascade on delete restrict,
    constraint ORDERLINE_TOOL_ToolID_fk
        foreign key (ToolID) references TOOL (ToolID)
            on update cascade on delete restrict
);

create table CLIENT
(
    ClientID int auto_increment
        primary key,
    LName varchar(50) null,
    FName varchar(50) null,
    Type varchar(20) null,
    PhoneNum varchar(10) null,
    Address text null,
    PostalCode varchar(20) null
);

create table PURCHASE
(
    ClientID int not null,
    ToolID int not null,
    Date timestamp not null,
    primary key (ClientID, ToolID, Date),
    constraint PURCHASE_CLIENT_ClientID_fk
        foreign key (ClientID) references CLIENT (ClientID)
            on update cascade on delete restrict,
    constraint PURCHASE_TOOL_ToolID_fk
        foreign key (ToolID) references TOOL (ToolID)
            on update cascade on delete restrict
);

create table ELECTRICAL
(
    ToolID int not null
        primary key,
    PowerType varchar(20) null,
    constraint ELECTRICAL_TOOL_ToolID_fk
        foreign key (ToolID) references TOOL (ToolID)
            on update cascade on delete restrict
);

create table INTERNATIONAL
(
    SupplierID int not null
        primary key,
    ImportTax float null,
    constraint INTERNATIONAL_SUPPLIER_SupplierID_fk
        foreign key (SupplierID) references SUPPLIER (SupplierID)
            on update cascade on delete restrict
);



create table USER
(
    username varchar(50) not null,
    password varchar(50) not null,
    constraint USER_username_uindex
        unique (username)
);

alter table USER
    add primary key (username);

