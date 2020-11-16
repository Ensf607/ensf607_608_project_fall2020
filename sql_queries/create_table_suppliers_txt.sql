use tool_shop;
drop table if exists  suppliers;
create table suppliers
(
    id int auto_increment,
    company_name text null,
    address text null,
    sales_contact text null,
    constraint suppliers_pk
        primary key (id)
);


