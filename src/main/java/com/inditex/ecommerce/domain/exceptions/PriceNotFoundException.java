package com.inditex.ecommerce.domain.exceptions;

import lombok.Setter;

public class PriceNotFoundException extends RuntimeException {
    @Setter
    private String message;

    public PriceNotFoundException(String message) {
        super(message);
    }
}
