package com.orderly.votybe.core.exceptions.errors;

import com.orderly.votybe.core.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class RateLimitException extends ApiException {
    public RateLimitException(String message) {
        super(HttpStatus.TOO_MANY_REQUESTS, message);
    }
}
