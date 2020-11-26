create table CLIENT
(
	ClientID int auto_increment,
	LName varchar(50) null,
	FName varchar(50) null,
	Type varchar(20) null,
	PhoneNum varchar(10) null,
	Address text null,
	PostalCode varchar(20) null,
	constraint CLIENT_pk
		primary key (ClientID)
);

