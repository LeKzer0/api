package com.pin2.proj.exceptions;

public class SituacaoNotFoundException extends RuntimeException {
    public SituacaoNotFoundException(Long id) {
        super("Situacao de número " + id + " não encontrado. ");
    }
}
