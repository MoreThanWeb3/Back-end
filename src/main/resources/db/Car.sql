CREATE TABLE Car (
                     id serial PRIMARY KEY  NOT NULL,
                     name VARCHAR(255) NOT NULL,
                     description TEXT,
                     brand VARCHAR(255)  NOT NULL,
                     model VARCHAR(255)  NOT NULL,
                     price DOUBLE PRECISION  NOT NULL,
                     color VARCHAR(255) ,
                     motor_type VARCHAR(255)  NOT NULL,
                     power INTEGER  NOT NULL,
                     place_number INTEGER  NOT NULL ,
                     status BOOLEAN,
                     type VARCHAR(255) NOT NULL
);