package com.product.exception;

import java.util.Objects;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, Object ... object) {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
