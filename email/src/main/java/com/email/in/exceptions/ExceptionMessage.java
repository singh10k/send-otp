package com.email.in.exceptions;

public enum ExceptionMessage {
    INTERNAL_SERVER_ERROR("Internal server error", "internal.server.error");

    private final String message;
    private final String errorCode;

    ExceptionMessage(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

