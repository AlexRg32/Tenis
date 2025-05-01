package com.backend.Tenis.exception;

public class NotFoundEntityException extends RuntimeException {
    public NotFoundEntityException(Long id, Class<?> entity) {
        super("La entidad "+ entity.getSimpleName() +" con el id " + id + " no existe");
    }
}
