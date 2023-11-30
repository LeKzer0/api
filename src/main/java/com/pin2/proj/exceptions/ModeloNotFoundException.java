package com.pin2.proj.exceptions;

public class ModeloNotFoundException extends RuntimeException {
    public ModeloNotFoundException(Long id) {
        super("Modelo de número " + id + " não encontrado. ");
    }
}
