package com.company.cesc.entity.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = OrderNotClosedValidator.class)
public @interface CheckOrderNotClosed {

    String message() default "{msg://com.company.cesc.entity.validation/CheckOrderNotClosed.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}