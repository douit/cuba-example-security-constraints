alter table CESC_LINE_ITEM add constraint FK_CESC_LINE_ITEM_ORDER foreign key (ORDER_ID) references CESC_ORDER(ID);
alter table CESC_LINE_ITEM add constraint FK_CESC_LINE_ITEM_PRODUCT foreign key (PRODUCT_ID) references CESC_PRODUCT(ID);
create index IDX_CESC_LINE_ITEM_ORDER on CESC_LINE_ITEM (ORDER_ID);
create index IDX_CESC_LINE_ITEM_PRODUCT on CESC_LINE_ITEM (PRODUCT_ID);
