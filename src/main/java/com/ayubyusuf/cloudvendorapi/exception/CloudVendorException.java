package com.ayubyusuf.cloudvendorapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Represents exceptions specific to cloud vendor operations.
 */
@Getter
@AllArgsConstructor
public class CloudVendorException extends RuntimeException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;
}
