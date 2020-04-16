insert into Person (name) values ('Horváth Béla');
insert into Person (name) values ('Sebes Tibor');
insert into Person (name) values ('Varga Géza');
insert into Person (name) values ('Katona Csenge');
insert into Person (name) values ('Jakab Anita');
insert into Person (name) values ('Orosz István');

insert into Department (name) values ('Accounting');
insert into Department (name) values ('Economics');
insert into Department (name) values ('Finance');
insert into Department (name) values ('Management');
insert into Department (name) values ('Marketing');

insert into Contact (person_id, contact_type, contact) values (1 , 0, '0612751698');
insert into Contact (person_id, contact_type, contact) values (1 , 1, '06203333333');
insert into Contact (person_id, contact_type, contact) values (1 , 2, 'horba@melonmail.com');
insert into Contact (person_id, contact_type, contact) values (2 , 0, '0617629654');
insert into Contact (person_id, contact_type, contact) values (2 , 1, '06308475435');
insert into Contact (person_id, contact_type, contact) values (2 , 2, 'sebi420@tefa.itl.ru');
insert into Contact (person_id, contact_type, contact) values (3 , 0, '0612547168');
insert into Contact (person_id, contact_type, contact) values (3 , 1, '06705463223');
insert into Contact (person_id, contact_type, contact) values (3 , 2, 'cnoorwood2@freemail.hu');
insert into Contact (person_id, contact_type, contact) values (4 , 0, '0612541187');
insert into Contact (person_id, contact_type, contact) values (4 , 1, '06705642964');
insert into Contact (person_id, contact_type, contact) values (4 , 2, 'ktn433@gmail.com');
insert into Contact (person_id, contact_type, contact) values (5 , 0, '0614323513');
insert into Contact (person_id, contact_type, contact) values (5 , 1, '06304627532');
insert into Contact (person_id, contact_type, contact) values (5 , 2, 'jakita@yahoo.com');
insert into Contact (person_id, contact_type, contact) values (6 , 0, '061654432');
insert into Contact (person_id, contact_type, contact) values (6 , 1, '0630654335');
insert into Contact (person_id, contact_type, contact) values (6 , 2, 'oisti@gmail.com');

insert into department_people (departments_id, people_id) values (1,1);
insert into department_people (departments_id, people_id) values (2,1);
insert into department_people (departments_id, people_id) values (3,1);
insert into department_people (departments_id, people_id) values (4,1);
insert into department_people (departments_id, people_id) values (5,1);
insert into department_people (departments_id, people_id) values (1,2);
insert into department_people (departments_id, people_id) values (5,3);
insert into department_people (departments_id, people_id) values (1,4);
insert into department_people (departments_id, people_id) values (2,5);
insert into department_people (departments_id, people_id) values (5,5);


insert into Admin (username, password) values ('beluci111', '$2a$10$i8PSkVr/QMgGesJAUmbfOubvj3nlb5osOE5bPJFOLxbN1b6c8pTm.');