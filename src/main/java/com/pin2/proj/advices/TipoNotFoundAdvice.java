package com.pin2.proj.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pin2.proj.exceptions.TipoNotFoundException;

@ControllerAdvice
class TipoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TipoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tipoNotFoundHandler(TipoNotFoundException ex) {
        return ex.getMessage();
    }
}