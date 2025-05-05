CREATE TABLE compra (
                        raqueta_id BIGINT NOT NULL,
                        tenista_id BIGINT NOT NULL,
                        CONSTRAINT fk_raqueta FOREIGN KEY (raqueta_id) REFERENCES raqueta(id),
                        CONSTRAINT fk_tenista FOREIGN KEY (tenista_id) REFERENCES tenista(id)
);
