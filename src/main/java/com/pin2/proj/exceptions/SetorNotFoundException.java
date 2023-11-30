package com.pin2.proj.exceptions;

public class SetorNotFoundException extends RuntimeException {
    public SetorNotFoundException(Long id) {
        super("Setor de número " + id + " não encontrado. ");
    }
}
