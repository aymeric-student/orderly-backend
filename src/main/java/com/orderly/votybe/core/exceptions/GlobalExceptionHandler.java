package com.orderly.votybe.core.exceptions;

import com.orderly.votybe.core.exceptions.models.ApiErrorResponse;
import com.orderly.votybe.core.exceptions.models.ValidationErrorDetail;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex, HttpServletRequest request) {
        ApiErrorResponse response = ApiErrorResponse.builder()
                .status(ex.getStatus().value())
                .error(ex.getStatus().getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(ex.getStatus()).body(response);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<ValidationErrorDetail> errorDetails = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> ValidationErrorDetail.builder()
                        .field(fieldError.getField())
                        .message(fieldError.getDefaultMessage() != null ? fieldError.getDefaultMessage() : "Validation error")
                        .build())
                .toList();

        ApiErrorResponse response = ApiErrorResponse.builder()
                .status(400)
                .error("Bad Request")
                .message("Validation failed")
                .path(request.getRequestURI())
                .errors(errorDetails)
                .build();

        return ResponseEntity.badRequest().body(response);
    }
}
