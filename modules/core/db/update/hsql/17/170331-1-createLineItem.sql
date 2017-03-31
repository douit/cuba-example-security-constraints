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
    PRICE_PER_ITEM decimal(19, 2) not null,
    AMOUNT integer not null,
    TOTAL_PRICE decimal(19, 2) not null,
    --
    primary key (ID)
);
