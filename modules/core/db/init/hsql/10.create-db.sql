-- begin CESC_CUSTOMER
create table CESC_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    FIRSTNAME varchar(255),
    STREET varchar(255),
    POSTCODE varchar(255),
    CITY varchar(255),
    STATE varchar(255),
    TYPE_ varchar(50),
    --
    primary key (ID)
)^
-- end CESC_CUSTOMER
-- begin CESC_ORDER
create table CESC_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_DATE date,
    STATUS varchar(50),
    CUSTOMER_ID varchar(36) not null,
    PAYMENT_METHOD varchar(50),
    CLOSED boolean,
    --
    primary key (ID)
)^
-- end CESC_ORDER
-- begin CESC_PRODUCT
create table CESC_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    PRICE decimal(19, 2),
    CATEGORY_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end CESC_PRODUCT
-- begin CESC_PRODUCT_CATEGORY
create table CESC_PRODUCT_CATEGORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end CESC_PRODUCT_CATEGORY
-- begin CESC_LINE_ITEM
create table CESC_LINE_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID varchar(36) not null,
    POSITION_ integer not null,
    PRODUCT_ID varchar(36) not null,
    QUANTITY integer not null,
    QUANTITY_UNIT varchar(50),
    UNIT_PRICE decimal(19, 2) not null,
    TOTAL_PRICE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end CESC_LINE_ITEM
