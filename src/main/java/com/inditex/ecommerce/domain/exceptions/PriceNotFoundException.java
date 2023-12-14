package com.inditex.ecommerce.domain.exceptions;


public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(String message) {
        super(message);
    }
}
