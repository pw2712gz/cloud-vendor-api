package com.ayubyusuf.cloudvendorapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to build and standardize HTTP responses throughout the application.
 */
public class ResponseHandler {

    /**
     * Builds a standardized HTTP response for API interactions.
     *
     * @param message   A message describing the context or result of the API call.
     * @param httpStatus The HTTP status code that should be returned.
     * @param body      The payload to be included in the response, typically data or a detailed error description.
     * @return ResponseEntity containing the custom structured map of the response.
     */
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object body) {
        Map<String, Object> response = new HashMap<>();
        response.put("body", body);
        response.put("status", httpStatus);
        response.put("message", message);
        return new ResponseEntity<>(response, httpStatus);
    }
}
