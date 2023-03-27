package com.employeestorageservice.employeestorageservice.exception;

public class EmployeeServiceBusinessException extends RuntimeException{
    public EmployeeServiceBusinessException(String message) {
        super(message);
    }
}
