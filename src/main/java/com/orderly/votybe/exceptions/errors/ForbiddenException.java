package com.orderly.votybe.exceptions.errors;

import com.orderly.votybe.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApiException {
    public ForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
