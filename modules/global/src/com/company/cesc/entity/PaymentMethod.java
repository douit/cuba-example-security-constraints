package com.company.cesc.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PaymentMethod implements EnumClass<String> {

    CREDIT_CARD("CREDIT_CARD"),
    PAYPAL("PAYPAL"),
    INVOICE("INVOICE");

    private String id;

    PaymentMethod(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PaymentMethod fromId(String id) {
        for (PaymentMethod at : PaymentMethod.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}