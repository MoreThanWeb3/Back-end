CREATE TABLE admin (
                       id SERIAL PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

INSERT INTO admin (email, password) VALUES ('admin@gmail.com', 'admin');