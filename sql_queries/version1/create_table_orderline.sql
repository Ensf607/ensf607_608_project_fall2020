create table ORDERLINE
(
	OrderID int not null,
	ToolID int not null,
	SupplierID int not null,
	Quantity int null,
	constraint ORDERLINE_pk
		primary key (OrderID, ToolID),
	constraint ORDERLINE_ORDER__OrderID_fk
		foreign key (OrderID) references ORDER_ (OrderID)
			on update cascade,
	constraint ORDERLINE_SUPPLIER_SupplierID_fk
		foreign key (SupplierID) references SUPPLIER (SupplierID)
			on update cascade,
	constraint ORDERLINE_TOOL_ToolID_fk
		foreign key (ToolID) references TOOL (ToolID)
			on update cascade
);

