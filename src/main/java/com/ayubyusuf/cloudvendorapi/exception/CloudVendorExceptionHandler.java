package com.ayubyusuf.cloudvendorapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handles exceptions globally for all controllers, providing specific responses.
 */
@ControllerAdvice
public class CloudVendorExceptionHandler {

    /**
     * Handles not found exceptions specifically for cloud vendor operations.
     *
     * @param exception the exception to handle
     * @return a ResponseEntity object with error details
     */
    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException exception) {
        CloudVendorException cloudVendorException = new CloudVendorException(
                exception.getMessage(),
                exception.getCause(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}
