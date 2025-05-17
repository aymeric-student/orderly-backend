package com.orderly.votybe.core.exceptions.errors;

import com.orderly.votybe.core.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApiException {
    public ForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
