CREATE TABLE Image (
                       id serial PRIMARY KEY  NOT NULL,
                       car_id int REFERENCES Car(id),
                       url TEXT
);