alter table CESC_ORDER add constraint FK_CESC_ORDER_CUSTOMER foreign key (CUSTOMER_ID) references CESC_CUSTOMER(ID);
create index IDX_CESC_ORDER_CUSTOMER on CESC_ORDER (CUSTOMER_ID);
