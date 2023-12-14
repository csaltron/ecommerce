package com.inditex.ecommerce.rest.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
public class ApiError {

    private HttpStatus status;
    private String message;
    private ZonedDateTime timeStamp;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, String errors, ZonedDateTime timeStamp) {
        super();
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.errors = Arrays.asList(errors);
    }

}
