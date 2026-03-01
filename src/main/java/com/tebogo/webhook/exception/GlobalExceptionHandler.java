package com.tebogo.webhook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<?> handleUserNotFoundException(InvalidInputException ex) {
        // extract field errors
        // build custom response
        APIErrorResponse response = new APIErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, (HttpStatus.BAD_REQUEST).getReasonPhrase(),ex.getMessage());

        // return ResponseEntity.badRequest().body(...)
        return ResponseEntity.badRequest().body(response);
    }
}
