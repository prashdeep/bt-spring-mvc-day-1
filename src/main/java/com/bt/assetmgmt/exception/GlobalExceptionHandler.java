package com.bt.assetmgmt.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntTimeException(Exception exception){
        return "Exception thrown from the global error handler";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> constraintViolationException(Exception exception){
        System.out.println(exception.getClass());
        System.out.println(exception.getMessage());

        return ResponseEntity.badRequest().body("Invalid value");
    }
}