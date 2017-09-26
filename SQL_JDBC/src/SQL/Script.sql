CREATE DATABASE Job4J;





/* right_roles */
CREATE TABLE right_roles (
	id SERIAL PRIMARY KEY, --PK
	add BOOLEAN NOT NULL DEFAULT false, 
	delete BOOLEAN NOT NULL DEFAULT false, 
	update BOOLEAN NOT NULL DEFAULT false,
	UNIQUE(add, delete, update)
);

INSERT INTO right_roles (add, delete, update) VALUES ('true', 'true', 'true');
INSERT INTO right_roles (add, delete, update) VALUES ('true', 'false', 'true');
INSERT INTO right_roles (add, delete, update) VALUES ('true', 'false', 'false');




/* roles */
CREATE TABLE roles (
	id SERIAL PRIMARY KEY, --PK
	role CHARACTER VARYING (100) NOT NULL,
	right_role_id INTEGER REFERENCES right_roles(id), --FK
	UNIQUE(role)
);

INSERT INTO roles (role, right_role_id) VALUES ('Master', (SELECT id FROM right_roles WHERE add = 'true' AND delete = 'true' AND update = 'true'));
INSERT INTO roles (role, right_role_id) VALUES ('Admin', (SELECT id FROM right_roles WHERE add = 'true' AND delete = 'false' AND update = 'true'));
INSERT INTO roles (role, right_role_id) VALUES ('User', (SELECT id FROM right_roles WHERE add = 'true' AND delete = 'false' AND update = 'false'));






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