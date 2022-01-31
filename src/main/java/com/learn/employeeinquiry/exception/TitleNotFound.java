package com.learn.employeeinquiry.exception;

public class TitleNotFound extends RuntimeException{
    public TitleNotFound() {
    }

    public TitleNotFound(String message) {
        super(message);
    }

    public TitleNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public TitleNotFound(Throwable cause) {
        super(cause);
    }

    public TitleNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
