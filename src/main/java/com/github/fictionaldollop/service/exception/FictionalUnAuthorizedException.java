package com.github.fictionaldollop.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class FictionalUnAuthorizedException extends RuntimeException {

    public FictionalUnAuthorizedException(String message) {
        super(message);
    }
}
