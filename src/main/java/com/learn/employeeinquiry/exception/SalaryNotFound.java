package com.learn.employeeinquiry.exception;

public class SalaryNotFound extends RuntimeException{
    public SalaryNotFound() {
    }

    public SalaryNotFound(String message) {
        super(message);
    }

    public SalaryNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public SalaryNotFound(Throwable cause) {
        super(cause);
    }

    public SalaryNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
