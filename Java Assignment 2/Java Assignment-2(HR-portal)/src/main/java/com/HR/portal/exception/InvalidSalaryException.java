package com.HR.portal.exception;

import org.springframework.http.HttpStatus;

public class InvalidSalaryException extends  RuntimeException {
    public InvalidSalaryException(HttpStatus badRequest, String message) {
        super(message);
    }

}
