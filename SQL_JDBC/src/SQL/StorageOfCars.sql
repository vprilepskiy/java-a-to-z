CREATE DATABASE stoarge_of_cars;
-- pass: POSTGRESQL;



CREATE TABLE transmission (
	id SERIAL PRIMARY KEY, --PK
	whell_drive CHARACTER VARYING (100) NOT NULL,
	UNIQUE(whell_drive)
);

INSERT INTO transmission (whell_drive) VALUES ('front');
INSERT INTO transmission (whell_drive) VALUES ('four');
INSERT INTO transmission (whell_drive) VALUES ('multi');
INSERT INTO transmission (whell_drive) VALUES ('rear');



CREATE TABLE gearbox (
	id SERIAL PRIMARY KEY, --PK
	type CHARACTER VARYING (100) NOT NULL,
	UNIQUE(type)
);

INSERT INTO gearbox (type) VALUES ('mechanical');
INSERT INTO gearbox (type) VALUES ('automatic');
INSERT INTO gearbox (type) VALUES ('variator');
INSERT INTO gearbox (type) VALUES ('robot');



CREATE TABLE engine (
	id SERIAL PRIMARY KEY, --PK
	force INTEGER NOT NULL,
	UNIQUE(force)
);

INSERT INTO engine (force) VALUES (70);
INSERT INTO engine (force) VALUES (110);
INSERT INTO engine (force) VALUES (125);
INSERT INTO engine (force) VALUES (160);
INSERT INTO engine (force) VALUES (211);



CREATE TABLE cars (
	id SERIAL PRIMARY KEY, --PK
	name CHARACTER VARYING (100) NOT NULL,
	transmission_id INTEGER REFERENCES transmission(id), --FK
	gearbox_id INTEGER REFERENCES gearbox(id), --FK
	engine_id INTEGER REFERENCES engine(id), --FK
	UNIQUE(name)
);

INSERT INTO cars (name, transmission_id, gearbox_id, engine_id)
	VALUES ('Skoda Fabia',
		(SELECT id FROM transmission WHERE whell_drive = 'front'),
		(SELECT id FROM gearbox WHERE type = 'automatic'),
		(SELECT id FROM engine WHERE force = 70));

INSERT INTO cars (name, transmission_id, gearbox_id, engine_id)
	VALUES ('Seat FreeTrack',
		(SELECT id FROM transmission WHERE whell_drive = 'multi'),
		(SELECT id FROM gearbox WHERE type = 'robot'),
		(SELECT id FROM engine WHERE force = 211));

INSERT INTO cars (name, transmission_id, gearbox_id, engine_id)
	VALUES ('Mitsubishi Outlender',
		(SELECT id FROM transmission WHERE whell_drive = 'four'),
		(SELECT id FROM gearbox WHERE type = 'variator'),
		(SELECT id FROM engine WHERE force = 160));



SELECT c.id, c.name, t.whell_drive, g.type, e.force
FROM cars AS c, transmission AS t, gearbox AS g, engine AS e
WHERE c.transmission_id = t.id
AND c.gearbox_id = g.id
AND c.engine_id = e.id;

SELECT t.whell_drive
FROM cars AS c
RIGHT JOIN transmission AS t ON c.transmission_id = t.id
WHERE c.name IS NULL;

SELECT g.type
FROM cars AS c
RIGHT JOIN gearbox AS g ON c.gearbox_id = g.id
WHERE c.name IS NULL;

SELECT e.force
FROM cars AS c
RIGHT JOIN engine AS e ON c.engine_id = e.id
WHERE c.name IS NULL;

