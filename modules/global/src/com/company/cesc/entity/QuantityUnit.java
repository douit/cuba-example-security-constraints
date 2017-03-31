package com.company.cesc.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum QuantityUnit implements EnumClass<String> {

    Piece("pc");

    private String id;

    QuantityUnit(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static QuantityUnit fromId(String id) {
        for (QuantityUnit at : QuantityUnit.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}