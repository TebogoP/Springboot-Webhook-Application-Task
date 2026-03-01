package com.tebogo.webhook.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class APIErrorResponse {
    private LocalDateTime timestamp;
    private HttpStatusCode status;
    private String error;
    private String messge;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatusCode getStatusCode() {
        return status;
    }

    public String getErrorName() {
        return error;
    }

    public String getErrMessge() {
        return messge;
    }

    public APIErrorResponse(LocalDateTime timestamp, HttpStatusCode statusCode, String errorName, String errMessge) {
        this.timestamp = timestamp;
        this.status = statusCode;
        this.error = errorName;
        this.messge = errMessge;
    }

}
