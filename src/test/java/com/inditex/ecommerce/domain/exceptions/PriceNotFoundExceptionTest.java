package com.inditex.ecommerce.domain.exceptions;

import com.inditex.ecommerce.rest.exceptions.ApiError;
import com.inditex.ecommerce.rest.exceptions.EcommerceExceptionHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        EcommerceExceptionHandler.class})
public class PriceNotFoundExceptionTest {

    @Test
    void checkPriceNotFoundExceptionTest() {
        final EcommerceExceptionHandler apiExceptionHandler = new EcommerceExceptionHandler();
        final String errorMessage = "Error message";
        final ResponseEntity<ApiError> apiErrorResponseEntity = apiExceptionHandler.handleNotFound(new PriceNotFoundException(errorMessage));
        assertThat(Objects.requireNonNull(apiErrorResponseEntity.getBody()).getMessage()).isEqualTo(errorMessage);
    }
}
