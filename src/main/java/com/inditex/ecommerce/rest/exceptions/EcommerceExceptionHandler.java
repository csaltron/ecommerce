package com.inditex.ecommerce.rest.exceptions;

import com.inditex.ecommerce.domain.exceptions.PriceNotFoundException;
import com.inditex.ecommerce.rest.utils.Util;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcommerceExceptionHandler {


    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(final PriceNotFoundException ex) {
        final var apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), ex.getMessage(), Util.getZonedDateTime());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(final Exception ex) {
        final var apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex.getMessage(), Util.getZonedDateTime());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }



}
