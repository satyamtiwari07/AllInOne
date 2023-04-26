package com.example.realTemp.exception;

public class VehicalNotFoundException extends RuntimeException{
    public VehicalNotFoundException() {
    }

    public VehicalNotFoundException(String message) {
        super(message);
    }

    public VehicalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
