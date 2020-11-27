create table TOOL
(
    ToolID     int auto_increment
        primary key,
    Name       varchar(50) null,
    Type       varchar(45) null,
    Quantity   int         null,
    Price      float       null,
    SupplierID int         null,
    constraint TOOL_SUPPLIER_SupplierID_fk
        foreign key (SupplierID) references SUPPLIER (SupplierID)
);

