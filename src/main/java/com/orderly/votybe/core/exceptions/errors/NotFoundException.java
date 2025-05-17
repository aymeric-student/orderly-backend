package com.orderly.votybe.core.exceptions.errors;


import com.orderly.votybe.core.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}

