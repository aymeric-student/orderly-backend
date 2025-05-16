package com.orderly.votybe.exceptions.errors;

import com.orderly.votybe.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
