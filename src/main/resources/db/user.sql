CREATE TABLE "User" (
                      id serial PRIMARY KEY,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      name VARCHAR(255)
);