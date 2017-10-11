--CREATE DATABASE Job4J;


/*
DROP TABLE roles CASCADE;
DROP TABLE rights CASCADE;
DROP TABLE right_roles CASCADE;
DROP TABLE users CASCADE;
DROP TABLE category_item CASCADE;
DROP TABLE status_item CASCADE;
DROP TABLE items CASCADE;
DROP TABLE comments CASCADE;
DROP TABLE files CASCADE;
*/


/* roles */
CREATE TABLE roles (
	id SERIAL PRIMARY KEY, --PK
	role CHARACTER VARYING (100) NOT NULL,
	UNIQUE(role)
);

INSERT INTO roles (role) VALUES ('Master');
INSERT INTO roles (role) VALUES ('Admin');
INSERT INTO roles (role) VALUES ('User');





/* rights */
CREATE TABLE rights (
	id SERIAL PRIMARY KEY, --PK
	description CHARACTER VARYING (100) NOT NULL,
	UNIQUE(description)
);

INSERT INTO rights (description) VALUES ('Add');
INSERT INTO rights (description) VALUES ('Delete');
INSERT INTO rights (description) VALUES ('Update');



/* right_roles */

CREATE TABLE right_roles (
	id SERIAL PRIMARY KEY, --PK
	rights_id INTEGER REFERENCES rights(id), --FK
	role_id INTEGER REFERENCES roles(id), --FK
	UNIQUE(rights_id, role_id)
);

INSERT INTO right_roles (rights_id, role_id) VALUES ((SELECT id FROM rights WHERE description = 'Add'), (SELECT id FROM roles WHERE role = 'Master'));
INSERT INTO right_roles (rights_id, role_id) VALUES ((SELECT id FROM rights WHERE description = 'Delete'), (SELECT id FROM roles WHERE role = 'Master'));
INSERT INTO right_roles (rights_id, role_id) VALUES ((SELECT id FROM rights WHERE description = 'Update'), (SELECT id FROM roles WHERE role = 'Master'));

INSERT INTO right_roles (rights_id, role_id) VALUES ((SELECT id FROM rights WHERE description = 'Add'), (SELECT id FROM roles WHERE role = 'Admin'));
INSERT INTO right_roles (rights_id, role_id) VALUES ((SELECT id FROM rights WHERE description = 'Update'), (SELECT id FROM roles WHERE role = 'Admin'));

INSERT INTO right_roles (rights_id, role_id) VALUES ((SELECT id FROM rights WHERE description = 'Add'), (SELECT id FROM roles WHERE role = 'User'));





/* users */
CREATE TABLE users (
	id SERIAL PRIMARY KEY, --PK
	login CHARACTER VARYING (100) NOT NULL, 
	password CHARACTER VARYING (100) NOT NULL, 
	create_date TIMESTAMP NOT NULL DEFAULT NOW(),
	role_id INTEGER REFERENCES roles(id), --FK
	UNIQUE(login)
);

INSERT INTO users (login, password, role_id) VALUES ('Petr', 'petrjob4j', (SELECT id FROM roles WHERE role = 'Master'));
INSERT INTO users (login, password, role_id) VALUES ('Arslan', 'arslanjob4j', (SELECT id FROM roles WHERE role = 'Master'));
INSERT INTO users (login, password, role_id) VALUES ('Vladimir', 'vladimirjob4j', (SELECT id FROM roles WHERE role = 'Admin'));
INSERT INTO users (login, password, role_id) VALUES ('Alex', 'alexjob4j', (SELECT id FROM roles WHERE role = 'User'));





/* category_item */
CREATE TABLE category_item (
	id SERIAL PRIMARY KEY, --PK
	name CHARACTER VARYING (100) NOT NULL, 
	UNIQUE(name)
);

INSERT INTO category_item (name) VALUES ('High');
INSERT INTO category_item (name) VALUES ('Medium');
INSERT INTO category_item (name) VALUES ('Low');





/* status_item */
CREATE TABLE status_item (
	id SERIAL PRIMARY KEY, --PK
	name CHARACTER VARYING (100) NOT NULL, 
	UNIQUE(name)
);

INSERT INTO status_item (name) VALUES ('Check in');
INSERT INTO status_item (name) VALUES ('In service');
INSERT INTO status_item (name) VALUES ('Closed');





/* items */
CREATE TABLE items (
	id SERIAL PRIMARY KEY, --PK
	description TEXT NOT NULL, 
	create_date TIMESTAMP NOT NULL DEFAULT NOW(),
	user_id INTEGER REFERENCES users(id), --FK
	category_id INTEGER REFERENCES category_item(id), --FK
	status_id INTEGER REFERENCES status_item(id) --FK
);

INSERT INTO items (description, user_id, category_id, status_id) 
	VALUES ('To train the juniors', 
		(SELECT id FROM users WHERE login = 'Petr'), 
		(SELECT id FROM category_item WHERE name = 'High'), 
		(SELECT id FROM status_item WHERE name = 'In service'));

INSERT INTO items (description, user_id, category_id, status_id) 
	VALUES ('To get a job as a java developer', 
		(SELECT id FROM users WHERE login = 'Vladimir'), 
		(SELECT id FROM category_item WHERE name = 'High'), 
		(SELECT id FROM status_item WHERE name = 'In service'));





/* comments */
CREATE TABLE comments (
	id SERIAL PRIMARY KEY, --PK
	description TEXT,
	item_id INTEGER REFERENCES items(id) --FK
);

INSERT INTO comments (description, item_id)
	VALUES ('achieve success', 
		(SELECT id FROM items WHERE user_id = (SELECT id FROM users WHERE login = 'Vladimir')));





/* files */
CREATE TABLE files (
	id SERIAL PRIMARY KEY, --PK
	name CHARACTER VARYING (100) NOT NULL,
	file BYTEA NOT NULL,
	item_id INTEGER REFERENCES items(id) --FK
);
