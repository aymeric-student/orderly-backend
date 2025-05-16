package com.orderly.votybe.exceptions.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationErrorDetail {
    private String field;
    private String message;
}

