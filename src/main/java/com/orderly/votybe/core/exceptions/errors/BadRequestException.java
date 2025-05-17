package com.orderly.votybe.core.exceptions.errors;

import com.orderly.votybe.core.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
