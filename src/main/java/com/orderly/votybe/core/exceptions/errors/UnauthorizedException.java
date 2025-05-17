package com.orderly.votybe.core.exceptions.errors;

import com.orderly.votybe.core.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiException {
    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}

