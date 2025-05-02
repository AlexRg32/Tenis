
CREATE TABLE academia (
id BIGINT AUTO_INCREMENT NOT NULL,
nombre VARCHAR(255) NULL,
ciudad VARCHAR(255) NULL,
pais VARCHAR(255) NULL,
CONSTRAINT pk_academia PRIMARY KEY (id)
);

-- Modificar tablas existentes
ALTER TABLE entrenador
ADD COLUMN academia_id BIGINT NULL;

-- Añadir foreign keys
ALTER TABLE entrenador
    ADD CONSTRAINT FK_ENTRENADOR_ON_ACADEMIA
        FOREIGN KEY (academia_id) REFERENCES academia (id);

-- Insertar academias
INSERT INTO academia (nombre, ciudad, pais)
VALUES ('Rafa Nadal Academy', 'Mallorca', 'España'),
       ('IMG Academy', 'Florida', 'Estados Unidos'),
       ('Mouratoglou Tennis Academy', 'Niza', 'Francia');

-- Actualizar entrenadores para asociarlos con academias
UPDATE entrenador
SET academia_id = 1
WHERE id = 1;

UPDATE entrenador
SET academia_id = 2
WHERE id = 2;

UPDATE entrenador
SET academia_id = 3
WHERE id = 3;

