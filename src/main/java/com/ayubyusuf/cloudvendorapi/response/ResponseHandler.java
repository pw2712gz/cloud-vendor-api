package com.ayubyusuf.cloudvendorapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object body) {
        Map<String, Object> response = new HashMap<>();
        response.put("body", body);
        response.put("status", httpStatus);
        response.put("message", message);
        return new ResponseEntity<>(response, httpStatus);
    }
}
