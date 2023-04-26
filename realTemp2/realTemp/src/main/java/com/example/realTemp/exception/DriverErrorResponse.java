package com.example.realTemp.exception;

import org.springframework.http.HttpStatus;

public class DriverErrorResponse {
    int Status;
    String message;

    long timeStamp;

    public DriverErrorResponse() {
    }

    public DriverErrorResponse(int Status, String message, long timeStamp) {
        this.Status = Status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(HttpStatus Status) {
        this.Status = Status.value();
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
