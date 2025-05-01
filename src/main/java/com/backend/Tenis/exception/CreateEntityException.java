package com.backend.Tenis.exception;

public class CreateEntityException extends RuntimeException {
    public  CreateEntityException(Class<?> entity, Throwable cause) {
        super("Error al crear la entidad " + entity.getSimpleName() + "\n" + cause.getMessage() + "\n");
    }
}
