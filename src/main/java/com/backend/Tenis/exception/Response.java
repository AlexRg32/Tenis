package com.backend.Tenis.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response  {
    private int code;
    private String message;
    private Map<String, String > errors;

    private Response(int errorCode, String errorMessage){
        code = errorCode;
        message = errorMessage;
        errors = new HashMap<>();
    }

    private Response(int errorCode, String errorMessage, Map<String, String> errors){
        this.code = errorCode;
        this.message = errorMessage;
        this.errors = errors;
    }

    public static Response noErrorResponse(String message){
        return new Response(HttpStatus.OK.value(), message);
    }

    public static Response notFoundError(Map<String, String> errors){
        return new Response(HttpStatus.NOT_FOUND.value(), "Not Found", errors);
    }

    public static Response generalError(Map<String, String> errors){
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", errors);
    }

    public static Response validationError(Map<String, String> errors){
        return new Response(HttpStatus.BAD_REQUEST.value(), "Validation Error", errors);
    }

}
