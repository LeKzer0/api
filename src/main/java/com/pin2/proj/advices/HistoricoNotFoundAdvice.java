package com.pin2.proj.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pin2.proj.exceptions.HistoricoNotFoundException;

@ControllerAdvice
class HistoricoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(HistoricoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String HistoricoNotFoundHandler(HistoricoNotFoundException ex) {
        return ex.getMessage();
    }
}