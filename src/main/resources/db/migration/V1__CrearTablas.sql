CREATE TABLE entrenador
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NULL,
    email  VARCHAR(50) NULL,
    CONSTRAINT pk_entrenador PRIMARY KEY (id)
);

CREATE TABLE ficha
(
    fecha_fin     datetime NULL,
    tenista_id    BIGINT NOT NULL,
    entrenador_id BIGINT NOT NULL,
    CONSTRAINT pk_ficha PRIMARY KEY (tenista_id, entrenador_id)
);

CREATE TABLE firma
(
    saldo        DECIMAL NULL,
    fecha_inicio date NULL,
    fecha_fin    date NULL,
    sponsor_id   BIGINT NOT NULL,
    tenista_id   BIGINT NOT NULL,
    CONSTRAINT pk_firma PRIMARY KEY (sponsor_id, tenista_id)
);

CREATE TABLE gana
(
    fecha      datetime NOT NULL,
    torneo_id  BIGINT   NOT NULL,
    tenista_id BIGINT   NOT NULL,
    CONSTRAINT pk_gana PRIMARY KEY (torneo_id, tenista_id)
);

CREATE TABLE raqueta
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    marca  VARCHAR(100) NULL,
    modelo VARCHAR(100) NULL,
    CONSTRAINT pk_raqueta PRIMARY KEY (id)
);

CREATE TABLE sponsor
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NULL,
    CONSTRAINT pk_sponsor PRIMARY KEY (id)
);

CREATE TABLE tenista
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    nombre       VARCHAR(50) NULL,
    apellido     VARCHAR(50) NULL,
    nacionalidad VARCHAR(50) NULL,
    CONSTRAINT pk_tenista PRIMARY KEY (id)
);

CREATE TABLE torneo
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NULL,
    premio DECIMAL NULL,
    puntos INT NULL,
    CONSTRAINT pk_torneo PRIMARY KEY (id)
);

ALTER TABLE ficha
    ADD CONSTRAINT FK_FICHA_ON_ENTRENADOR FOREIGN KEY (entrenador_id) REFERENCES entrenador (id);

ALTER TABLE ficha
    ADD CONSTRAINT FK_FICHA_ON_TENISTA FOREIGN KEY (tenista_id) REFERENCES tenista (id);

ALTER TABLE firma
    ADD CONSTRAINT FK_FIRMA_ON_SPONSOR FOREIGN KEY (sponsor_id) REFERENCES sponsor (id);

ALTER TABLE firma
    ADD CONSTRAINT FK_FIRMA_ON_TENISTA FOREIGN KEY (tenista_id) REFERENCES tenista (id);

ALTER TABLE gana
    ADD CONSTRAINT FK_GANA_ON_TENISTA FOREIGN KEY (tenista_id) REFERENCES tenista (id);

ALTER TABLE gana
    ADD CONSTRAINT FK_GANA_ON_TORNEO FOREIGN KEY (torneo_id) REFERENCES torneo (id);



INSERT INTO entrenador (nombre, email)
VALUES ('Carlos Pérez', 'carlos.perez@correo.com'),
       ('Ana Gómez', 'ana.gomez@correo.com'),
       ('Luis Martínez', 'luis.martinez@correo.com');


INSERT INTO tenista (nombre, apellido, nacionalidad)
VALUES ('Rafael', 'Nadal', 'España'),
       ('Roger', 'Federer', 'Suiza'),
       ('Novak', 'Djokovic', 'Serbia');


INSERT INTO sponsor (nombre)
VALUES ('Nike'),
       ('Adidas'),
       ('Wilson');


INSERT INTO torneo (nombre, premio, puntos)
VALUES ('Roland Garros', 2000000, 2000),
       ('Wimbledon', 2500000, 2500),
       ('US Open', 3000000, 3000);

INSERT INTO raqueta (marca, modelo)
VALUES ('Babolat', 'Pure Aero'),
       ('Wilson', 'Pro Staff'),
       ('Head', 'Speed Pro');

INSERT INTO ficha (tenista_id, entrenador_id, fecha_fin)
VALUES (1, 1, '2024-12-31'),
       (2, 2, '2025-12-31'),
       (3, 3, '2026-12-31');


INSERT INTO firma (sponsor_id, tenista_id, saldo, fecha_inicio, fecha_fin)
VALUES (1, 1, 50000.00, '2023-01-01', '2024-01-01'),
       (2, 2, 75000.00, '2023-02-01', '2024-02-01'),
       (3, 3, 100000.00, '2023-03-01', '2024-03-01');

INSERT INTO gana (torneo_id, tenista_id, fecha)
VALUES (1, 1, '2023-06-11'),
       (2, 2, '2023-07-15'),
       (3, 3, '2023-09-10');