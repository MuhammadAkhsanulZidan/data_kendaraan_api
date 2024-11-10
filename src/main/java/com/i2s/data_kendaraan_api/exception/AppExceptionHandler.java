package com.i2s.data_kendaraan_api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.security.access.AccessDeniedException;

import com.i2s.data_kendaraan_api.dto.APIResponseDto;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponseDto<String>> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        APIResponseDto<String> errorResponse = new APIResponseDto<>(HttpStatus.NOT_FOUND.toString(),
                ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<APIResponseDto<String>> IllegalArgumentException(Exception ex, WebRequest request) {
        APIResponseDto<String> errorResponse = new APIResponseDto<>(HttpStatus.BAD_REQUEST.toString(),
                ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<APIResponseDto<String>> BadCredentialsException(Exception ex, WebRequest request) {
        APIResponseDto<String> errorResponse = new APIResponseDto<>(HttpStatus.UNAUTHORIZED.toString(),
                ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<APIResponseDto<String>> AccessDeniedException(Exception ex, WebRequest request) {
        APIResponseDto<String> errorResponse = new APIResponseDto<>(HttpStatus.UNAUTHORIZED.toString(),
                ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponseDto<String>> globalExceptionHandler(Exception ex, WebRequest request) {
        APIResponseDto<String> errorResponse = new APIResponseDto<>(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<APIResponseDto<String>> handleJpaSystemException(JpaSystemException ex, WebRequest request) {
        APIResponseDto<String> errorResponse = new APIResponseDto<>(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Database error: " + ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponseDto<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        APIResponseDto<Map<String, String>> errorResponse = new APIResponseDto<>(
                HttpStatus.BAD_REQUEST.toString(), "Validation error", errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
