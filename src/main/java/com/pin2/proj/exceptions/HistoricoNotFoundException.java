package com.pin2.proj.exceptions;

public class HistoricoNotFoundException extends RuntimeException {
    public HistoricoNotFoundException(Long id) {
        super("Historico de número " + id + " não encontrado. ");
    }
}
