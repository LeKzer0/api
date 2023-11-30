package com.pin2.proj.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
        super("Usuario de número " + id + " não encontrado. ");
    }
}
