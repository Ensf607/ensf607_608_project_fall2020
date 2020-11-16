-- need to create the supplier table first!
use tool_shop;
drop table if exists  items;
create table items
(
	id int auto_increment,
	description_name text null,
	quantity_in_stock int null,
	price float null,
	supplier_id int null,
	constraint items_pk
		primary key (id),
	constraint suppliers_suppliers_id_fk
		foreign key (supplier_id) references suppliers (id)
			on update cascade on delete set null
);

