package com.tebogo.webhook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<APIErrorResponse> handleUserNotFoundException(InvalidInputException ex) {
        // extract field errors

        // build custom response
        APIErrorResponse error = new APIErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                (HttpStatus.BAD_REQUEST).getReasonPhrase(),
                ex.getMessage());

        // return ResponseEntity.badRequest().body(...)
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIErrorResponse> handle500(Exception ex) {

        APIErrorResponse error = new APIErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                (HttpStatus.INTERNAL_SERVER_ERROR).getReasonPhrase(),
                ex.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<APIErrorResponse> handle404(NoHandlerFoundException ex){

        APIErrorResponse error = new APIErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                (HttpStatus.NOT_FOUND).getReasonPhrase(),
                "Endpoint does not exist \n" + ex.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
