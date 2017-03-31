package com.company.cesc.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CustomerType implements EnumClass<String> {

    LOYAL("LOYAL"),
    NEW("NEW"),
    ANGRY("ANGRY"),
    CASH_COW("CASH_COW");

    private String id;

    CustomerType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CustomerType fromId(String id) {
        for (CustomerType at : CustomerType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}