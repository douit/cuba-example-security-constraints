package com.company.cesc.entity.validation;

import com.company.cesc.entity.Order;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderNotClosedValidator implements ConstraintValidator<CheckOrderNotClosed, Order> {

    @Override
    public void initialize(CheckOrderNotClosed constraintAnnotation) {
    }

    @Override
    public boolean isValid(Order value, ConstraintValidatorContext context) {
        return !value.getClosed();
    }
}