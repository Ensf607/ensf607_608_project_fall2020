create table TOOL
(
	ToolID int auto_increment,
	Name varchar(50) null,
	Quantity int null,
	Price float null,
	SupplierID int null,
	constraint TOOL_pk
		primary key (ToolID),
	constraint TOOL_SUPPLIER_SupplierID_fk
		foreign key (SupplierID) references SUPPLIER (SupplierID)
);



