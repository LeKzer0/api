package com.pin2.proj.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("Item de número " + id + " não encontrado. ");
    }
}
