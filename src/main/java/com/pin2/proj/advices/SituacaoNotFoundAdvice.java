package com.pin2.proj.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pin2.proj.exceptions.SituacaoNotFoundException;

@ControllerAdvice
class SituacaoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SituacaoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tipoNotFoundHandler(SituacaoNotFoundException ex) {
        return ex.getMessage();
    }
}