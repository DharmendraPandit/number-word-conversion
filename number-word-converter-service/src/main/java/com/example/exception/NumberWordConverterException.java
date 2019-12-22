package com.example.exception;

public class NumberWordConverterException extends RuntimeException {
    private final int status;
    private final String message;
    private String errorCode;

    public NumberWordConverterException(int status, String message, String errorCode) {
        super(message);
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
