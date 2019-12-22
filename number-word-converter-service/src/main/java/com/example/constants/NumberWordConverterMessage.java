package com.example.constants;

public enum NumberWordConverterMessage {

    INVALID_INPUT("Invalid number"),
    EMPTY_INPUT("Number cannot be null"),
    INVALID_INPUT_ERROR_CODE("INVALID_INPUT"),
    EMPTY_INPUT_ERROR_CODE("EMPTY_INPUT");

    private String message;

    private NumberWordConverterMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
