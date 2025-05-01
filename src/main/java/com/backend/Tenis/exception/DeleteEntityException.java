package com.backend.Tenis.exception;

public class DeleteEntityException extends RuntimeException {
    public DeleteEntityException(Long id, Class<?> entity, Throwable cause) {
        super("Error al eliminar la entidad " + entity.getSimpleName() + " con el id " + id + "\n" + cause.getMessage() + "\n");
    }
}
