package org.example.java6nfa25sd20203.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomResourceNotFoundException extends RuntimeException{

    public CustomResourceNotFoundException(String message) {
        super(message);
    }
}
