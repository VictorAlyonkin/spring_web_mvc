package ru.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IsExistException extends RuntimeException {
    public IsExistException(String message) {
        super(message);
    }
}
