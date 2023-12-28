package com.github.fictionaldollop.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FictionalBadRequestException extends RuntimeException {

    public FictionalBadRequestException(String message) {
        super(message);
    }
}
