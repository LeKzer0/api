package com.pin2.proj.exceptions;

public class ItemAlreadyExistsException extends RuntimeException {
    public ItemAlreadyExistsException(String patrimonio) {
        super("Item de patrimônio " + patrimonio + " já cadastrado.");
    }
}
