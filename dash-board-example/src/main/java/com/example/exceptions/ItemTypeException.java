package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemTypeException extends RuntimeException {
    public ItemTypeException(String message) {
        super(message);
    }
}
