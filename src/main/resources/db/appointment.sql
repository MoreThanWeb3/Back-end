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