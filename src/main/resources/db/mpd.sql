create database car;
\c car

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
INSERT INTO Car (name, description, brand, model, price, color, motor_type, power, place_number, status, type)
VALUES
    ('Bugatti Bolide', 'bolides le plus rapides en 2024', 'Bugatti', 'Model A', 4000000, 'Red', 'Gasoline', 1850, 4, true, 'SUV'),
    ('Dodge Challenger', 'voiture de classe', 'Dodge', 'V8', 300000, 'Blue', 'Diesel',500, 4, false, 'Sedan'),
    ('Bugatti Chiron', ' La 2nd à battre le record de vitesse', 'Ferrari', 'V8 bi-turbo', 2000000, 'Green', 'Electric', 1817, 5, true, 'Hatchback');


CREATE TABLE Image (
                       id serial PRIMARY KEY  NOT NULL,
                       car_id int REFERENCES Car(id),
                       url TEXT
);
INSERT INTO Image (car_id, url)
VALUES
    (1, 'https://upload.wikimedia.org/wikipedia/commons/d/d0/Bugatti_Bolide_Milano.jpg'),
    (1, 'https://www.bugatti.com/media/l5mpxsc1/iv-10-bolide-desktop.jpeg'),
    (2, 'https://wallpapercave.com/uwp/uwp4359652.jpeg'),
    (3, 'https://wallpapercave.com/wp/wp13385267.jpg');


CREATE TABLE Appointment (
                             id serial  PRIMARY KEY,
                             car_id int REFERENCES Car(id),
                             name VARCHAR(255) NOT NULL,
                             first_name VARCHAR(255) NOT NULL,
                             email VARCHAR(255) NOT NULL ,
                             message TEXT,
                             contact VARCHAR(255)  NOT NULL,
                             appointment_date TIMESTAMP  NOT NULL,
                             status VARCHAR(50) CHECK (status IN ('pending', 'validated', 'rejected', 'archived'))
);
INSERT INTO Appointment (car_id, name, first_name, email, message, contact, appointment_date, status)
VALUES
    (1, 'Harizo', 'Haingo', 'harizo@gmail.com', 'Looking to buy this car', '+261 34 88 448 68', '2024-05-30 10:00:00', 'pending'),
    (2, 'Deux', 'Tiavina', 'tiavin@gmail.com', 'Interested in a test drive', '+261 32 57 778 44', '2024-06-01 14:00:00', 'validated'),
    (3, 'Ravo', 'Geraldo', 'gerald@gmail.com', 'Would like more information', '+261 33 18 184 68', '2024-06-05 16:00:00', 'rejected');

CREATE TABLE "User" (
                      id serial PRIMARY KEY,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      name VARCHAR(255)
);
INSERT INTO "User" (email, password, name)
VALUES
    ('admin@example.com', 'azerty', 'Admin admin'),
    ('manager@example.com', 'carshow', 'Manager Two'),
    ('user@example.com', 'usernoob', 'User user');