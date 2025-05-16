package com.orderly.votybe.exceptions.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiErrorResponse {
    private int status;
    private String error;
    private String message;
    private String path;
    private List<ValidationErrorDetail> errors;
}
