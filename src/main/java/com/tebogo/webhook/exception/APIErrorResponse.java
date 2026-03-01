package com.tebogo.webhook.exception;

import java.time.LocalDateTime;

public class APIErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public APIErrorResponse(LocalDateTime timestamp, int statusCode, String error, String message) {
        this.timestamp = timestamp;
        this.status = statusCode;
        this.error = error;
        this.message = message;
    }

}
