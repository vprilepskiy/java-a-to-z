create table cars (id serial PRIMARY KEY, mark varchar(255), model varchar(255));

create table VIN (id serial PRIMARY KEY, number varchar(255), car_id INTEGER REFERENCES cars(id)); --FK


