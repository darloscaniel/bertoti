CREATE DATABASE skateboardbd;

CREATE TABLE boards (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    size VARCHAR(50) NOT NULL
);

INSERT INTO boards (brand, size) VALUES
('Element', '8.0'),
('Santa Cruz', '8.25'),
('Powell Peralta', '7.75');