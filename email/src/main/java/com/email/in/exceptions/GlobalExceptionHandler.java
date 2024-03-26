package com.email.in.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponseException> handleException(Exception ex) {
        // Handle the exception here
        String errorMessage = "An error occurred: " + ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(getErrorResponse(errorMessage,
                        HttpStatus.CONFLICT.value(),
                        ExceptionMessage.INTERNAL_SERVER_ERROR.getErrorCode()));
    }

    @ExceptionHandler(MassageErrorException.class)
    public ResponseEntity<RestResponseException> handleYourSpecificException(MassageErrorException ex) {
        // Handle your specific exception here
        String errorMessage = "Your specific error occurred: " + ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(getErrorResponse(errorMessage,
                        HttpStatus.CONFLICT.value(),
                        ExceptionMessage.INTERNAL_SERVER_ERROR.getErrorCode()));
    }
    public static RestResponseException getErrorResponse(String message, Integer statusCode, String errorCode) {
        return RestResponseException.builder().message(message).status(statusCode).build();
    }
}
