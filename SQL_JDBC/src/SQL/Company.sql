/*
DROP TABLE company;
DROP TABLE person;
*/

CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

/*
// 1) Retrieve in a single query:
// - names of all persons that are NOT in the company with id = 5
// - company name for each person
// 2) Select the name of the company with the maximum number of persons + number of persons in this company
*/

INSERT INTO company (id, name) VALUES (0, 'Job4J');
INSERT INTO company (id, name) VALUES (1, 'SUN Microsystems');
INSERT INTO company (id, name) VALUES (2, 'IBM');
INSERT INTO company (id, name) VALUES (3, 'Microsoft');
INSERT INTO company (id, name) VALUES (4, 'Oracle');
INSERT INTO company (id, name) VALUES (5, 'SAP SE');

INSERT INTO person (id, name, company_id) VALUES (0, 'Peter Arsentiev', 0);
INSERT INTO person (id, name, company_id) VALUES (1, 'Andy Bechtolsheim', 1);
INSERT INTO person (id, name, company_id) VALUES (2, 'Scott Macneil', 1);
INSERT INTO person (id, name, company_id) VALUES (3, 'Charles Ranlett Flint', 2);
INSERT INTO person (id, name, company_id) VALUES (4, 'Ginni Rometty', 2);
INSERT INTO person (id, name, company_id) VALUES (5, 'John W. Thompson', 3);
INSERT INTO person (id, name, company_id) VALUES (6, 'Bill Gates', 3);
INSERT INTO person (id, name, company_id) VALUES (7, 'Satya Nadella', 3);
INSERT INTO person (id, name, company_id) VALUES (8, 'Larry Ellison', 4);
INSERT INTO person (id, name, company_id) VALUES (9, 'Jeff Henley', 4);
INSERT INTO person (id, name, company_id) VALUES (10, 'Hasso Plattner', 5);
INSERT INTO person (id, name, company_id) VALUES (11, 'Bill McDermott', 5);
INSERT INTO person (id, name, company_id) VALUES (12, 'Vladimir Prilepskiy', 6);


SELECT p.name, c.name
 FROM person p
 LEFT OUTER JOIN company c
 ON p.company_id = c.id
 WHERE p.company_id <> 5;

SELECT c.name company_name, COUNT(p.name) count_persons
 FROM company c
 LEFT OUTER JOIN person p
 ON c.id = p.company_id
 GROUP BY c.name
 ORDER BY 2 DESC
 LIMIT 1;




