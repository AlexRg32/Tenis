ALTER TABLE sponsor add column pais varchar(50) null;

UPDATE sponsor SET pais = 'Estados Unidos' WHERE nombre = 'Nike';
UPDATE sponsor SET pais = 'Alemania' WHERE nombre = 'Adidas';
UPDATE sponsor SET pais = 'Estados Unidos' WHERE nombre = 'Wilson';
