package com.gabrielcarvalhotp.api.meumercado.controllers.exceptions;

import com.gabrielcarvalhotp.api.meumercado.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardException> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardException standardException = new StandardException(LocalDateTime.now(), status.value(), "Resource not found", exception.getMessage());
        return ResponseEntity.status(status).body(standardException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardException> handleException(Exception exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardException standardException = new StandardException(LocalDateTime.now(), status.value(), "Internal server error", exception.getMessage());
        return ResponseEntity.status(status).body(standardException);
    }
}
