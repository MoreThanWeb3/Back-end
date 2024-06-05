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
    ('Tesla Model S', 'Luxury electric sedan', 'Tesla', 'Model S', 79999.99, 'Red', 'Electric', 1020, 5, TRUE, 'Sedan'),
    ('Ford Mustang', 'Iconic American muscle car', 'Ford', 'Mustang GT', 55995.00, 'Blue', 'Gasoline', 450, 4, TRUE, 'Coupe'),
    ('BMW 3 Series', 'Compact executive car', 'BMW', '330i', 41300.00, 'Black', 'Gasoline', 255, 5, TRUE, 'Sedan'),
    ('Audi Q5', 'Luxury compact SUV', 'Audi', 'Q5 45 TFSI', 51900.00, 'White', 'Gasoline', 261, 5, TRUE, 'SUV'),
    ('Chevrolet Camaro', 'High-performance sports car', 'Chevrolet', 'Camaro SS', 42995.00, 'Yellow', 'Gasoline', 455, 4, TRUE, 'Coupe'),
    ('Toyota Corolla', 'Reliable and fuel-efficient compact car', 'Toyota', 'Corolla LE', 20325.00, 'Silver', 'Gasoline', 139, 5, TRUE, 'Sedan'),
    ('Honda Civic', 'Compact car with sporty handling', 'Honda', 'Civic EX', 24350.00, 'Gray', 'Gasoline', 180, 5, TRUE, 'Sedan'),
    ('Mercedes-Benz C-Class', 'Luxury compact car', 'Mercedes-Benz', 'C 300', 44100.00, 'Black', 'Gasoline', 255, 5, TRUE, 'Sedan'),
    ('Jeep Wrangler', 'Rugged off-road SUV', 'Jeep', 'Wrangler Rubicon', 44195.00, 'Green', 'Gasoline', 285, 5, TRUE, 'SUV'),
    ('Porsche 911', 'High-performance luxury sports car', 'Porsche', '911 Carrera', 101200.00, 'White', 'Gasoline', 379, 4, TRUE, 'Coupe'),
    ('Volkswagen Golf', 'Compact hatchback with versatile features', 'Volkswagen', 'Golf TSI', 23700.00, 'Blue', 'Gasoline', 147, 5, TRUE, 'Hatchback'),
    ('Lamborghini Aventador', 'Exotic high-performance sports car', 'Lamborghini', 'Aventador SVJ', 517770.00, 'Yellow', 'Gasoline', 759, 2, TRUE, 'Coupe'),
    ('Ferrari F8 Tributo', 'Supercar with exceptional performance', 'Ferrari', 'F8 Tributo', 276550.00, 'Red', 'Gasoline', 710, 2, TRUE, 'Coupe'),
    ('Nissan Leaf', 'Affordable electric car', 'Nissan', 'Leaf SV', 31400.00, 'White', 'Electric', 147, 5, TRUE, 'Hatchback'),
    ('Mazda CX-5', 'Compact crossover SUV', 'Mazda', 'CX-5 Grand Touring', 35400.00, 'Red', 'Gasoline', 227, 5, TRUE, 'SUV');

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