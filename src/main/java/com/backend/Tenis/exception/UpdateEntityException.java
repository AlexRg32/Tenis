package com.backend.Tenis.exception;

public class UpdateEntityException extends RuntimeException {
    public UpdateEntityException(Class<?> entity, Throwable cause) {
        super("Error al modificar la entidad " + entity.getSimpleName() + "\n" + cause.getMessage() + "\n");
    }
}
