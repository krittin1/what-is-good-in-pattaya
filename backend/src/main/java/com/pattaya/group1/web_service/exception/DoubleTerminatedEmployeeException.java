package com.pattaya.group1.web_service.exception;

public class DoubleTerminatedEmployeeException extends RuntimeException {
    public DoubleTerminatedEmployeeException(String message) {
        super(message);
    }
}
