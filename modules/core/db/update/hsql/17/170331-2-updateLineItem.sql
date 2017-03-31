alter table CESC_LINE_ITEM add column QUANTITY integer ^
update CESC_LINE_ITEM set QUANTITY = 0 where QUANTITY is null ;
alter table CESC_LINE_ITEM alter column QUANTITY set not null ;
alter table CESC_LINE_ITEM add column QUANTITY_UNIT varchar(50) ;
alter table CESC_LINE_ITEM add column UNIT_PRICE decimal(19, 2) ^
update CESC_LINE_ITEM set UNIT_PRICE = 0 where UNIT_PRICE is null ;
alter table CESC_LINE_ITEM alter column UNIT_PRICE set not null ;
alter table CESC_LINE_ITEM drop column PRICE_PER_ITEM cascade ;
alter table CESC_LINE_ITEM drop column AMOUNT cascade ;
