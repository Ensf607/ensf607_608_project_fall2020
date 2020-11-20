create table INTERNATIONAL
(
	SupplierID int not null,
	ImportTax float null,
	constraint INTERNATIONAL_pk
		primary key (SupplierID),
	constraint INTERNATIONAL_SUPPLIER_SupplierID_fk
		foreign key (SupplierID) references SUPPLIER (SupplierID)
			on update cascade
);

