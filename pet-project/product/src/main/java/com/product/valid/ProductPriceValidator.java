package com.product.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductPriceValidator implements ConstraintValidator<ProductPriceValid, Double>{
    @Override
    public void initialize(ProductPriceValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Double product, ConstraintValidatorContext context) {
        return product >= 0;
    }
}
