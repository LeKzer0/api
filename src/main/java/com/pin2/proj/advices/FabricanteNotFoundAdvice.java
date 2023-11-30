package com.pin2.proj.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pin2.proj.exceptions.FabricanteNotFoundException;

@ControllerAdvice
class FabricanteNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FabricanteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String fabricanteNotFoundHandler(FabricanteNotFoundException ex) {
        return ex.getMessage();
    }
}