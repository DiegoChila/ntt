package com.ntt.demo.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomHttpException extends Exception {

    private HttpStatus httpStatus;

    public CustomHttpException(String error, HttpStatus httpStatus) {
        super(error);
        this.httpStatus = httpStatus;
    }

}
