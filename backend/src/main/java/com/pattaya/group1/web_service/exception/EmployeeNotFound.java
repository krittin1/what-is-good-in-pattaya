package com.pattaya.group1.web_service.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String message) {
        super(message);
    }
}
