package com.pin2.proj.exceptions;

public class TipoNotFoundException extends RuntimeException {
    public TipoNotFoundException(Long id) {
        super("Tipo de número " + id + " não encontrado. ");
    }
}
