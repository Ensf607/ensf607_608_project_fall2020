create table ELECTRICAL
(
	ToolID int not null,
	PowerType varchar(20) null,
	constraint ELECTRICAL_pk
		primary key (ToolID),
	constraint ELECTRICAL_TOOL_ToolID_fk
		foreign key (ToolID) references TOOL (ToolID)
			on update cascade
);