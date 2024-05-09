package com.ayubyusuf.cloudvendorapi.exception;

import org.springframework.http.HttpStatus;

public class CloudVendorException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;

    public CloudVendorException(String message, Throwable cause, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = cause;
        this.status = httpStatus;
    }

    public String getMessage() {
        return message;
    }
    public Throwable getThrowable() {
        return throwable;
    }
    public HttpStatus getStatus() {
        return status;
    }


}
