create table PURCHASE
(
	ClientID int not null,
	ToolID int not null,
	Date TIMESTAMP not null,
	constraint PURCHASE_pk
		primary key (ClientID, ToolID, Date),
	constraint PURCHASE_CLIENT_ClientID_fk
		foreign key (ClientID) references CLIENT (ClientID)
			on update cascade,
	constraint PURCHASE_TOOL_ToolID_fk
		foreign key (ToolID) references TOOL (ToolID)
			on update cascade
);

