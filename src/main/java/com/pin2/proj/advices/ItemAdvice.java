package com.pin2.proj.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pin2.proj.exceptions.ItemAlreadyExistsException;
import com.pin2.proj.exceptions.ItemNotFoundException;

@ControllerAdvice
class ItemAdvice {

    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ItemNotFoundHandler(ItemNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ItemAlreadyExistsException.class)
    public Error ItemAlreadyExistsHandler(ItemAlreadyExistsException ex) {
        return new Error(ex.getMessage());

    }
}