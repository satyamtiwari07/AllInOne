package com.example.realTemp.exception;

import org.springframework.http.HttpStatus;

public class VehicalErrorResponse {
    int Status;

    String message;

    long timeStamp;

    public VehicalErrorResponse() {
    }

    public VehicalErrorResponse(int status, String message, long timeStamp) {
        Status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(HttpStatus status) {
        Status = status.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
