package com.company.cesc.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum OrderStatus implements EnumClass<String> {

    RECEIVED("RECEIVED"),
    PAYED("PAYED"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED"),
    ON_HOLD("ON_HOLD"),
    CLOSED("CLOSED");

    private String id;

    OrderStatus(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static OrderStatus fromId(String id) {
        for (OrderStatus at : OrderStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}