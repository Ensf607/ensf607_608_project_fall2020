drop table if exists SUPPLIER;
create table SUPPLIER
(
	SupplierID int auto_increment,
	Name varchar(50) null,
	Type varchar(20) null,
	Address text null,
	CName varchar(50) null,
	Phone varchar(10) null,
	constraint SUPPLIER_pk
		primary key (SupplierID)
);