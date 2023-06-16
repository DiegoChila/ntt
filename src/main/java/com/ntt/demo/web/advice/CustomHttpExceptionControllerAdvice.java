package com.ntt.demo.web.advice;

import com.ntt.demo.domain.exceptions.CustomHttpException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class CustomHttpExceptionControllerAdvice {

    @ExceptionHandler(CustomHttpException.class)
    public ResponseEntity<Map<String, Object>> validationException(CustomHttpException e) {
        return new ResponseEntity<>(Map.of("errors", List.of(e.getMessage())), e.getHttpStatus());
    }
}
