package com.pin2.proj.exceptions;

public class FabricanteNotFoundException extends RuntimeException {
    public FabricanteNotFoundException(Long id) {
        super("Fabricante de número " + id + " não encontrado. ");
    }
}
