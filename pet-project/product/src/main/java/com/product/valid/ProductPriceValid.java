package com.product.valid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductPriceValidator.class)
public @interface ProductPriceValid {
    String message() default "Price must be greater than 0";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
