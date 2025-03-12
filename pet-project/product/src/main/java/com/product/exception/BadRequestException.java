package com.product.exception;

import java.util.Objects;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Object ...  objects) {
                super(message);
    }
}
